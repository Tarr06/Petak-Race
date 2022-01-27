import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class PetakRaceFitur {

    //Winpoint
    final static int WINPOINT = 30;

    //Map
    static Map < Integer , Integer > palang = new HashMap < Integer , Integer >();

    //Rintangan
    {
        palang.put(6,2);
        palang.put(16,10);
        palang.put(26,20);
    }

    //Lempar Dadu
    public int LemparDadu()
    {
        int n = 0;
        Random r = new Random();
        n = r.nextInt(7);
        return (n == 0 ? 1:n);
    }

    //Point dari Player
    public int Langkah(int player, int NilaiDadu)
    {
        player = player + NilaiDadu;

        if(player > WINPOINT)
        {
            player = player - NilaiDadu;
            return player;
        }
        if(null!=palang.get(player))
        {
            System.out.println("mundurki kanda");
            player= palang.get(player);
        }

        return player;
    }

    //Jika Player ada yang Menang
    public boolean Pemenang(int player)
    {
        return WINPOINT == player;
    }

    //StartGame
    public void startGame()
    {
        int player1 =0, player2=0;
        int currentPlayer=-1;
        Scanner input = new Scanner(System.in);
        String str;
        int NilaiDadu =0;
        System.out.println("Masukkan nama player 1: ");
        String First = input.nextLine();
        System.out.println("Masukkan nama player 2: ");
        String Second = input.nextLine();

        do
        {
            System.out.println(currentPlayer==-1?"\n\n" + First + " TURN":"\n\n" + Second + " TURN");
            System.out.println("Press r to roll Dice");
            str = input.next();
            NilaiDadu = LemparDadu();


            if(currentPlayer == -1)
            {
                player1 = Langkah(player1,NilaiDadu);
                System.out.println(First + " : " + player1);
                for(int i = 0; i < player1; i++) {
                    System.out.print("* ");
                }
                System.out.println("");
                System.out.println(Second + " : " + player2);
                for(int i = 0; i < player2; i++) {
                    System.out.print("* ");
                }
                System.out.println("");
                System.out.println("------------------");
                if(Pemenang(player1))
                {
                    System.out.println(First + " wins");
                    return;
                }
            }
            else
            {
                player2 = Langkah(player2,NilaiDadu);
                System.out.println(First + " :: " + player1);
                for(int i = 0; i < player1; i++) {
                    System.out.print("* ");
                }
                System.out.println("");
                System.out.println(Second + " :: " + player2);
                for(int i = 0; i < player2; i++) {
                    System.out.print("* ");
                }
                System.out.println("");
                System.out.println("------------------");
                if(Pemenang(player2))
                {
                    System.out.println(Second + "wins");
                    return;
                }
            }

            currentPlayer= -currentPlayer;



        }while("r".equals(str));
    }


}