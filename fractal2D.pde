



void setup(){
  size(1700,1000);
  int size = 1000;
 Line line = new Line(350, 600, size,0);
  
  line.evolve( (int)(log(size)/log(2)) );
  //this code block shows the inner repetitions
  /*
  int coefficient = 200;
  Line line = new Line(200, 800,coefficient*0.5,-coefficient*(1.73/2));
Line second = new Line(200+coefficient*0.5,800+-coefficient*(sqrt(3)/2),coefficient*0.5,coefficient*(sqrt(3)/2));
 line.display();
 second.display();
 second.evolve(0);
  line.evolve(0);
  */
  //line.display()

  for(int x = 0; x<5; x++){
    line = new Line(100+x*300, 800, 200,0);
    line.evolve(x);
  }
   for(int x = 5; x<10; x++){
    line = new Line(100+(x-5)*300, 975, 200,0);
    line.evolve(x);
  }
  
}