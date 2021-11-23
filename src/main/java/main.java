import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        DataBase.connect();
        System.out.println("=======================\nWelcome to our app :)\n=======================");
        Admin admin=new Admin("3mtaha","yoyo");
        while (true) {
            System.out.println("============Main Menu============\n1-Register.\n2-LogIn\n3-Exit");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            if (choose == 1) {
                while (true) {
                    System.out.println("============Register============\n1-User.\n2-Driver\n3-Back to Start menu");
                    int choose2 = scanner.nextInt();
                    if (choose2 == 1) {
                        UserRegister userRegister = new UserRegister();
                        userRegister.Register();
                        break;
                    } else if (choose2 == 2) {
                        DriverRegister driverRegister = new DriverRegister();
                        driverRegister.Register();
                        break;
                    } else if (choose2 == 3) {
                        break;
                    } else {
                        System.out.println("Your choice is wrong.");
                    }
                }
            }
            else if (choose == 2) {
                while (true) {
                    System.out.println("============LogIn============\n1-User.\n2-Driver\n3-Admin\n4-Back to Start menu");
                    int choose2 = scanner.nextInt();
                    if (choose2 == 1) {
                        UserLogin login = new UserLogin();
                        Person user = login.login();
                        if (login.isLogin()) {
                            while (true) {
                                System.out.println("1-Request a Ride\n2-open Profile\n3-My pending Rides\n4-Rate Driver\n5-LogOut");
                                int choose3 = scanner.nextInt();
                                if (choose3 == 1) {
                                    RequestRide ride=new RequestRide();
                                    ride.requestRide(user.getUserName());
                                }
                                else if(choose3==2){
                                    System.out.println(user);
                                }
                                else if (choose3 == 3) {
                                    MyPendingRides.MyPendingRides(user.getUserName());

                                }
                                else if(choose3==4){
                                    DriverRate.Rate(user.getUserName());
                                }
                                else if (choose3 == 5) {
                                    user = null;
                                    break;
                                }
                            }
                        }


                    }
                    else if (choose2 == 2) {
                        DriverLogin login = new DriverLogin();
                        Person driver = login.login();
                        if (login.isLogin()) {
                            while (true) {

                                System.out.println("1-Add Favorite Area\n2-Remove Favorite Area\n3-List All Favorite Areas\n4-Choose a Ride\n5-LogOut");
                                int choose3 = scanner.nextInt();
                                if (choose3 == 1) {
                                    System.out.println("Enter Source Location:");
                                    String src=scanner.next();
                                    FavArea favArea=new FavArea();
                                    favArea.addFav(src,driver.getUserName());
                                }
                                else if (choose3 == 2) {
                                    System.out.println("Enter Source Location:");
                                    String src=scanner.next();
                                    FavArea favArea=new FavArea();
                                    favArea.removeFav(src,driver.getUserName());

                                }
                                else if (choose3==3){
                                    System.out.println("===================");
                                    FavArea favArea=new FavArea();
                                    favArea.listFav(driver.getUserName());
                                    System.out.println("===================");
                                }
                                else if (choose3==4){
                                    Offer.Offer(driver.getUserName());
                                }


                                else if (choose3==5 ) {
                                    driver = null;
                                    break;
                                }
                            }
                        }
                    }
                    else if(choose2==3){
                        System.out.print("UserName:");
                        String userName=scanner.next();
                        System.out.print("Password:");
                        String password=scanner.next();
                        if (admin.getName().equals(userName)&&admin.getPassword().equals(password)){
                            while (true) {
                                System.out.println("1-Suspend User.\n2-Suspend Driver\n3-Verify User\n4-Verify Driver\n5-LogOut");
                                int choose3 = scanner.nextInt();
                                if (choose3 == 1) {
                                    System.out.print("Choose UserName to suspend:");
                                    String u = scanner.next();
                                    admin.suspendUser(u);
                                }
                                else if (choose3 == 2) {
                                    System.out.println("Choose DriverName to suspend:");
                                    String d = scanner.next();
                                    admin.suspendDriver(d);
                                }
                                else if (choose3 == 3) {
                                    System.out.println("Choose UserName to Verify:");
                                    String u = scanner.next();
                                    admin.verifyUser(u);
                                }
                                else if (choose3 == 4) {
                                    admin.listPending();
                                    System.out.print("Choose DriverName to Verify:");
                                    String d = scanner.next();
                                    admin.verifyDriver(d);
                                }
                                else if (choose3 == 5) {
                                    break;
                                }
                            }
                        }
                    }
                    else if(choose2==4){
                        break;
                    }
                    else {
                        System.out.println("Wrong Entry");
                    }
                }
            }
            else if (choose == 3) {
                System.out.println("Bye :(");
                DataBase.disconnect();
                break;
            }
        }
    }
}
