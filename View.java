
package assig1;

import java.util.Arrays;
import java.util.Scanner;


public class View
{
static Board bo=new Board();
    static public char[][] gameboard;
     private  String one="1";
     private  String two="2";
     private  String tree="3";
    //gameboard constructor
  public View()
    {
       gameboard=new char[3][3];
        for(int row=0;row<gameboard.length;row++)
        {
            for(int col=0;col<gameboard.length;col++)
        
             {
           // Arrays.fill(gameboard[row],'.');//fill rows with dots
            gameboard[row][col] = '.';
             }       
      
        }
    }

    public void displayBoard()
    {
        System.out.print("\t"+one);
       System.out.print("\t"+two);
        System.out.println("\t"+tree);
        for(int row=0;row<gameboard.length;row++)
        { 
           
            System.out.print(row+1);
            System.out.print("  ");
            for(int col=0;col<gameboard[0].length;col++)
            {
               // System.out.print(col+1);
                System.out.print("\t"+gameboard[row][col]);
                if(col==0 || col==1 )
                    System.out.print(" ");
      
            }
        System.out.println("\n     \n");
        }
        System.out.println();
    }
    
     

//method to pick row and column,validate inputs  and call methos makemove
public void askplayer(char player)
    {    
    Scanner rowin=new Scanner(System.in);
     Scanner colin=new Scanner(System.in);

    int row,col;
   do 
    {
        
         
    System.out.printf("Player %s Please enter a row from 1-3 :",player);
   
    
        row = rowin.nextInt();
        while(row>3 ||row<1) 
    {
          System.out.print("Please Ensure that the row you entered is within the boundaties ");
           row = rowin.nextInt();
    }
     // rowin.close();
     
    System.out.printf("Player %s Please enter a column from 1-3 :", player);
       col = colin.nextInt();
        while(col>3 ||col<1) 
    {
          System.out.print("Please Ensure that the col you entered is within the boundaties ");
          col = colin.nextInt();
    }
     
      System.out.println("Row:"+row);
        System.out.println("Column:"+col);
    }
    while(bo .notValid(row,col));
   
    bo.makemove(player,row-1,col-1);
    }

 
}
