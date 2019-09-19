
package assig1;


public class Controller {
public static void main(String args[])
{
     View mygame=new View();
    Board mm=new Board();
   

int counters=1;
   mygame.displayBoard();
 while(mm.gameactive() && counters<10)
  {    
       if(counters%2==0)
       {
           System.out.println("Computer is Thinking");
           mm.computer_move();
       }

       else
       {
           mygame.askplayer('X');
       }
       counters++;
       System.out.println("\n");
       mm.checkforwinner();
    
        
       mygame.displayBoard();
       if(counters==10)
       {
           System.out.println("Stale");
           mm.gamegoing=false;
       }
   }
      
    }
          
}
