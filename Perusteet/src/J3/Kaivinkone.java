package J3;

//Kaivinkone
//Suunnitelmani on että ohjelma vastaanottaa komentoja käyttäjältä, ja suorittaa komentoja vastaavan toiminnon

import java.util.Scanner;

//luodaan Kaivinkone luokka
class Kaivinkone {

    static int travel_motorL = 0; //moottori valmius tilassa
    static int travel_motorR = 0; //moottori valmius tilassa
    static int swing_drive = 90; //kaivinkoneen alustan suunta eteenpäi, tällöin liike laajuus molempiin suuntiin 90 astetta
    static int Hydralic_cylinder_1 = 0 ; //puomin 1 sylinterin asento on nollassa
    static int Hydralic_cylinder_2 = 0; //puomin 2 sylinterin asento on nollassa
    static int tool = 90; // työkalu linjassa puomin osan 2 kanssa

    public static void main(String[] args){

    Scanner reader = new Scanner(System.in); //luodaan lukija 
    
    while(true){ // luodaan totuus looppi
    vaihtoehdot();
    String Read = reader.nextLine();//luetaan komento 
   //verrataan käyttäjän syötettä ja suoritetaan toiminto sen mukauisesti
        if (Read.equals("f")){
            forward();
        } else if (Read.equals("b")){
            reverse();
        } else if (Read.equals("r")){
            Right();
        } else if (Read.equals("l")){
            Left();
        } else if (Read.equals("s")){
            Stop();
        } else if (Read.equals("u")){
            Part1UP();
        } else if (Read.equals("d")){
            Part1DOWN();
        } else if (Read.equals("e")){
            Part2Extract();
        } else if (Read.equals("c")){
            Part2Substract();
        } else if (Read.equals("g")){
            Part3Grab();
        } else if (Read.equals("a")){
            Part3Release();
        } else if (Read.equals("n")){
            BucketR();
        } else if (Read.equals("m")){
            BucketL();
        } else if (Read.equals("z")){
            break;
        } else {System.out.println("Invalid input");}
    }
    reader.close();
}
    
    //vaihtoehdot
    public static void vaihtoehdot() {
        System.out.print("***System commands***" +
            "\n|Forward[f] " + "Reverse[b] " + "Left[l] " + "Right[r]|" + 
            "\n|Rotate R[n] " + "Rotate L[m] " + "UP[u] " + "DOWN[d]|" + 
            "\n|Etract[e] " + "Substract[c] " +"Grab[g] " + "Release[a]|" + 
            "\n|STOP[s] " + "END Program[z]|"+
            "\nTerminal ready: ");
    }


    // *********Metodit, jossa tulostetaan suoritettava komento ja muuttaa muuttujan arvon.**********

    //Tela
    public static void forward(){System.out.println("Moving Forward"); travel_motorL = 20;travel_motorR = 20;}
    public static void reverse(){System.out.println("Moving reverse");travel_motorL = -20;travel_motorR = -20;}
    public static void Right(){System.out.println("Turning Right");travel_motorL = 20;travel_motorR = -20;}
    public static void Left(){System.out.println("Turning Left");travel_motorL = -20;travel_motorR = 20;}
    public static void Stop(){System.out.println("Standby"); travel_motorL = 0; travel_motorR = 0; Hydralic_cylinder_1 = 0 ; Hydralic_cylinder_2 = 0; swing_drive = 0;}

    //Puomi
    public static void Part1UP (){System.out.println("Section 1 UP"); Hydralic_cylinder_1 = 5 ;}
    public static void Part1DOWN(){System.out.println("Section 1 DOWN");Hydralic_cylinder_1 = -5;}
    public static void Part2Extract (){System.out.println("Section 2 Extract");Hydralic_cylinder_2 = 5;}
    public static void Part2Substract (){System.out.println("Section 2 Substract");Hydralic_cylinder_2 = -5;}

    //kauha 
    public static void Part3Grab (){System.out.println("Section 3 Grab"); tool = 30;}
    public static void Part3Release (){System.out.println("Section 3 Release");tool = 90;}

    //kone
    public static void BucketR (){System.out.println("Bucket Rotate right");swing_drive = 5;}
    public static void BucketL (){System.out.println("Bucket Rotate left");swing_drive = -5;}

    }

