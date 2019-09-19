
package assig1;

import static assig1.View.gameboard;
import java.util.Arrays;
import java.util.Scanner;


public class Board {
static View  mygame = new View();
 boolean gamegoing=true;
  int counters=1; 
  public boolean gameactive()
   {
       return gamegoing;
   }
 
   //to check if the  row and column are between 1 and 3 and i the postion is just a dot
   public boolean notValid(int row,int col)
   {
      if (row >3 || row<1 || col > 3|| col <1 || !isdot(row,col))
       
        return true;
       
     else
           
     return false;

   } 
    public boolean makemove(char player, int row,int col)
   {
    if(row>=0 && row<=2 && col>=0 && col<=2)
    
    {
        if (mygame.gameboard[row][col]!='.')
           return false;
         else 
        {  
           mygame.gameboard[row][col] = player; //print the player's move as decided
            return true;   
        }
    }
      else
       return false; 
     
    }
    public  void computer_move() 
   {
       
    boolean changed=true;
    while(changed)
    {
        int move = (int)(Math.random()*9);

        int roww=move/3;
        int coll=move%3;
    
        if(gameboard[roww][coll] == '.' && gameboard[roww][coll] != 'X'
                ) 
	 

        {
           makemove('O',roww,coll);
           changed= false;
        }
       
    }
   }
  public boolean isdot(int row,int col)
{
           if (this.mygame.gameboard[row-1][col-1]=='.')
               return true;
          else 
           {
               System.out.println("The position is taken.\n");
           
               
                 return false;
           }
}
  //check for winner 3 in arow
  public boolean checkforwinner()
   {

      //loop over rows to be sure there is no space and they are all the same symbol
      for(int row=0;row<mygame.gameboard.length;row++)
          
      { 
     
            
          if(mygame.gameboard[row][0]==mygame.gameboard[row][1]&& mygame.gameboard[row][1]== mygame.gameboard[row][2] && mygame.gameboard[row][0]!='.')
          {
           if(mygame.gameboard[row][0]=='X')
           System.out.println("The winner is X");
           else
         System.out.println("The Computer Won !!");

           gamegoing=false;
           return true;
              
          }
                   
      }
            //loop over columns to be sure there is no space and they are all the same symbol
for(int col=0;col<mygame.gameboard[0].length;col++)
      {
          if(mygame.gameboard[0][col]==mygame.gameboard[1][col]&& mygame.gameboard[1][col]== mygame.gameboard[2][col] && mygame.gameboard[0][col]!='.')
            {
           
             if(mygame.gameboard[0][col]=='X')
           System.out.println("The winner is X");
           else
         System.out.println("The Computer Won !!");
                        gamegoing=false;
                       return true;
          }
                   
      }
//check for diagonals
if(mygame.gameboard[0][0]==mygame.gameboard[1][1]&&mygame.gameboard[1][1] ==mygame.gameboard[2][2]&& mygame.gameboard[1][1]!='.')
     {
           
              if(mygame.gameboard[1][1]=='X')
           System.out.println("The winner is X");
           else
         System.out.println("The Computer Won !!");
                       gamegoing=false;
                        return true;
          }
      if(mygame.gameboard[2][0]==mygame.gameboard[1][1]&&mygame.gameboard[1][1] ==mygame.gameboard[0][2]&& mygame.gameboard[0][2]!='.')
    {
           
                if(mygame.gameboard[0][2]=='X')
           System.out.println("The winner is X");
           else
         System.out.println("The Computer Won !!");
                        gamegoing=false;
                    return true;
          }   
         gamegoing=true;
      return false;
  }
}
