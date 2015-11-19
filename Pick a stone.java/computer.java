
import java.util.Random;


public class computer extends guy{

    main timer = new main();


computer(String n){

    

    name = n;

}

@Override

public int startTurn(){

    

    try {

        Thread.sleep(timer.time * 2);

    } catch (InterruptedException e) {

        

    }


    Random r = new Random();

    

    rocksInHand = r.nextInt(numRocks + 1);

    

    System.out.println(name + " has chosen his rocks");

    

    return(rocksInHand);

}

//n doit etre le numTotalRocks du main




@Override

 public int Turn (int n){



    

    

    try {

    Thread.sleep(timer.time * 2);

} catch (InterruptedException e) {

    

}

    /*

    int w = 0;





 for(int i = 0; i< previousAnswers.length; i++){

    w -= ( (int) n/2 - previousAnswers[i]);

}

*/

    Random whynot = new Random();

    

choice = rocksInHand + whynot.nextInt(n - numRocks + 1);

//pour une difficulté plus élevé:

//choice = rocksInHand + (int)((n - rocksInHand)/2) + w;

if(numRocks != 1 && choice != 1){

System.out.println(name + " (he has " + numRocks + " rocks) : I think there are " + choice + " rocks");

}

else if (numRocks == 1){

    System.out.println(name + " (he has " + numRocks + " rock) : I think there are " + choice + " rocks");

}

else if(choice == 1){

    System.out.println(name + " (he has " + numRocks + " rocks) : I think there is " + choice + " rock");

}

else{

    System.out.println(name + " (he has " + numRocks + " rock) : I think there is " + choice + " rock");

}

return(choice);

}

}




