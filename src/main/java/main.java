import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("=======================\nWelcome to our app :)\n=======================");
        while (true) {
            Admin ad=new Admin("3mtaha","yoyo");
            ad.listPending();
            ad.verifyDriver("Huda");
            System.out.println("1-Register.\n2-LogIn\n3-Exit");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            if (choose == 1) {
                while (true) {
                    System.out.println("1-User.\n2-Driver\n3-Back to Start menu");
                    int choose2 = scanner.nextInt();
                    if (choose2 == 1) {
                        UserRegister userRegister = new UserRegister();
                        userRegister.Register();
                    } else if (choose2 == 2) {
                        DriverRegister driverRegister = new DriverRegister();
                        driverRegister.Register();
                    } else if (choose2 == 3) {
                        break;
                    } else {
                        System.out.println("Your choice is wrong.");
                    }
                }
            }
            else if (choose == 2) {
                while (true) {
                    System.out.println("1-User.\n2-Driver\n3-Back to Start menu");
                    int choose2 = scanner.nextInt();
                    if (choose2 == 1) {
                        UserLogin login = new UserLogin();
                        Person user = login.login();
                        if (login.isLogin()) {
                            while (true) {
                                System.out.println("1-Request A Ride");
                                System.out.println("2-open Profile");
                                System.out.println("3-LogOut");
                                int choose3 = scanner.nextInt();
                                if (choose3 == 1) {

                                } else if (choose3 == 2) {
                                    System.out.println(user);

                                } else if (choose3 == 3) {
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
                                System.out.println("1-Add Favorite Area\n2-Remove Favorite Area\n3-List All Favorite Areas\n4-LogOut");
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
                                else if (choose3 == 4) {
                                    driver = null;
                                    break;
                                }
                            }
                        } else if (choose2 == 3) {
                            break;
                        } else {
                            System.out.println("Your choice is wrong.");
                        }
                    }
                    else if(choose2==3){
                        break;
                    }
                    else {
                        System.out.println("Wrong Entry");
                    }
                }
            }
            else if (choose == 3) {
                System.out.println("Bye :(");
                break;
            }
        }
    }
}
