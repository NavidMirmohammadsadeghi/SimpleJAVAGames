import java.util.*;
// 3 for user won field!
// 4 for user self hurting shot
// 5 for user missed
// 6 for comp won
// 7 for comp self
// 8 for comp miss

public class BattleShip {

    public static void main(String[] args){
        System.out.println(" *** Welcome to Battle Ships Game *** ");
        System.out.println(" Right now, the sea is empty.");
        int[][] map = new int[10][10];
        map = Draw_first_map(map);
        map = Deploy_players_ship(map);
        map = Deploy_Computers_ship(map);
        Battle(map);




    }

        public static int[][]  Draw_first_map(int[][] map) {

            System.out.println("   0123456789  ");
            int counter = 0;

            for (int j = 0; j < map.length; j++) {
                System.out.print(counter+" |");
                for(int k=0;k<map[j].length;k++){
                    if(map[j][k]==1){
                        System.out.print("@");
                    }else if(map[j][k]==3 || map[j][k]==7){
                        System.out.print("!");
                    }else if(map[j][k]==4 || map[j][k]==6){
                        System.out.print("x");
                    }else if(map[j][k]==5){
                        System.out.print("-");
                    }else{
                        System.out.print(" ");
                    }
                    }

                System.out.print("|"+counter+"\n");
                counter += 1;
            }

            System.out.println("   0123456789  ");
            return  map;
        }

        public static int[][]  Deploy_players_ship(int[][] map){
        int counter = 1;
        Scanner x_coord = new Scanner(System.in);
        Scanner y_coord = new Scanner(System.in);
        System.out.println("Deploy your ships:");

        for(int count=1;count<6;count++){
            int Correct =0;
            while(Correct==0) {
                System.out.print("Enter X Coordinate for your " + counter + " .ship: ");
                int X_cord = x_coord.nextInt();
                System.out.print("Enter Y Coordinate for your " + counter + " .ship: ");
                int Y_cord = y_coord.nextInt();
                if(X_cord<10 && X_cord>=0 && Y_cord>=0 && Y_cord<10 && map[X_cord][Y_cord]!=1){
                    map[X_cord][Y_cord] = 1;
                    Correct =1;
                }

            }
            counter +=1;
        }
        Draw_first_map(map);
        return map;
        }

        public static int[][] Deploy_Computers_ship(int[][] map){

        Random rand_x = new Random();
        Random rand_y = new Random();
        int counter = 1;
            for(int count=1;count<6;count++){
                int Correct =0;
                while(Correct==0) {
                    int X_cord = rand_x.nextInt(10);
                    int Y_cord = rand_y.nextInt(10);
                    if(X_cord<10 && X_cord>=0 && Y_cord>=0 && Y_cord<10 && map[X_cord][Y_cord]!=1){
                        map[X_cord][Y_cord] = 2;
                        Correct =1;
                        System.out.println(counter+" .ship Deployed!");
                    }

                }
                counter +=1;
            }
            return map;
        }

        public static void Battle(int[][] map){

          int ship_user = 5;
          int ship_comp = 5;

          ArrayList<String> player_xS = new ArrayList<>();
          //ArrayList<Integer> player_yS = new ArrayList<>();

          ArrayList<String> comp_xS = new ArrayList<>();

            int Iter_user    = 0;
            int Iter_comp = 0;
          //ArrayList<Integer> comp_yS = new ArrayList<>();





          //int Sum_both_players = ship_comp+ship_user;

          while(ship_user!=0 && ship_comp!=0){

              // First Let the Player Choose
              int correct_user = 1;
              int correct_comp = 1;
              Scanner player_x = new Scanner(System.in);
              Scanner player_y = new Scanner(System.in);

              Random comp_x = new Random();
              Random comp_y = new Random();




              System.out.println("YOUR TURN");
              while(correct_user==1){
                  System.out.print("Enter X Coordinate: ");
                  int player_guessed_x = player_x.nextInt();
                  System.out.print("Enter Y Coordinate: ");
                  int player_guessed_y = player_y.nextInt();
                  if(player_guessed_x>=0 && player_guessed_x<10 && player_guessed_y>=0 && player_guessed_y<10){
                      if(Iter_user==0){
                          if(map[player_guessed_x][player_guessed_y]==2){
                              System.out.println("Boom!You Sunk the ship!");
                              map[player_guessed_x][player_guessed_y] =3;
                              ship_comp -=1;
                          }
                          else if(map[player_guessed_x][player_guessed_y]==1){
                              System.out.println("Oh no!You Sunk your own ship!");
                              map[player_guessed_x][player_guessed_y] =4;
                              ship_user -=1;
                          }
                          else if(map[player_guessed_x][player_guessed_y]!=1 || map[player_guessed_x][player_guessed_y]!=2){
                              System.out.println("Sorry you missed!");
                              map[player_guessed_x][player_guessed_y] =5;
                          }
                          player_xS.add(player_guessed_x+"-"+player_guessed_y);
                          //player_yS.add(player_guessed_y);
                          Iter_user +=1;
                          correct_user =0;
                      }else if(player_xS.indexOf(player_guessed_x+"-"+player_guessed_y)==-1 && Iter_user>0){
                          if(map[player_guessed_x][player_guessed_y]==2){
                              System.out.println("Boom!You Sunk the ship!");
                              map[player_guessed_x][player_guessed_y] =3;
                              ship_comp -=1;
                          }
                          else if(map[player_guessed_x][player_guessed_y]==1){
                              System.out.println("Oh no!You Sunk your own ship!");
                              map[player_guessed_x][player_guessed_y] =4;
                              ship_user -=1;
                          }
                          else if(map[player_guessed_x][player_guessed_y]!=1 || map[player_guessed_x][player_guessed_y]!=2){
                              System.out.println("Sorry you missed!");
                              map[player_guessed_x][player_guessed_y] =5;
                          }
                          player_xS.add(player_guessed_x+"-"+player_guessed_y);
                          //player_yS.add(player_guessed_y);
                          Iter_user +=1;
                          correct_user =0;

                      }
                  }

              }
              Draw_first_map(map);
              System.out.println("Your ships: "+ship_user +" | "+"Computer ships: "+ ship_comp);
              //System.out.println(player_xS);
              //System.out.println(Iter_user);

              System.out.println("Computer Turn!");
              while(correct_comp==1){
                  int comp_guessed_x = comp_x.nextInt(10);
                  int comp_guessed_y = comp_y.nextInt(10);
                  if(comp_guessed_x>=0 && comp_guessed_x<10 && comp_guessed_y>=0 && comp_guessed_y<10){
                      if(Iter_comp==0){
                          if(map[comp_guessed_x][comp_guessed_y]==1){
                              System.out.println("The Computer Sunk one of your ships!");
                              map[comp_guessed_x][comp_guessed_y] =6;
                              ship_user -=1;
                          }
                          else if(map[comp_guessed_x][comp_guessed_y]==2){
                              System.out.println("Computer Sunk One of its own!");
                              map[comp_guessed_x][comp_guessed_y] =7;
                              ship_comp -=1;
                          }
                          else if(map[comp_guessed_x][comp_guessed_y]!=1 || map[comp_guessed_x][comp_guessed_y]!=2){
                              System.out.println("Computer missed!");
                              //map[comp_guessed_x][comp_guessed_y] =8;
                          }
                          comp_xS.add(comp_guessed_x+"-"+comp_guessed_y);
                          //comp_yS.add(comp_guessed_y);
                          Iter_comp +=1;
                          correct_comp =0;
                      }else if(comp_xS.indexOf(comp_guessed_x+"-"+comp_guessed_y)==-1 && Iter_comp>0){
                          if(map[comp_guessed_x][comp_guessed_y]==1){
                              System.out.println("The Computer Sunk one of your ships!");
                              map[comp_guessed_x][comp_guessed_y] =6;
                              ship_user -=1;
                          }
                          else if(map[comp_guessed_x][comp_guessed_y]==2){
                              System.out.println("Computer Sunk One of its own!");
                              map[comp_guessed_x][comp_guessed_y] =7;
                              ship_comp -=1;
                          }
                          else if(map[comp_guessed_x][comp_guessed_y]!=1 || map[comp_guessed_x][comp_guessed_y]!=2){
                              System.out.println("Computer missed!");
                              //map[comp_guessed_x][comp_guessed_y] =5;
                          }
                          comp_xS.add(comp_guessed_x+"-"+comp_guessed_y);
                          //player_yS.add(comp_guessed_y);
                          Iter_comp +=1;
                          correct_comp =0;

                      }
                  }

              }
              Draw_first_map(map);
              System.out.println("Your ships: "+ship_user +" | "+"Computer ships: "+ ship_comp);



          }

          if (ship_user >ship_comp){
              System.out.println("Your ships: "+ship_user +" | "+"Computer ships: "+ ship_comp);
              System.out.println("Hooray! You won the game!");
          }else{
              System.out.println("Your ships: "+ship_user +" | "+"Computer ships: "+ ship_comp);
              System.out.println("Damn you lost!!!:(");
          }






        }

}
