
static ArrayList<Line> lines = new ArrayList<Line>(100);


void setup(){
  size(500,500);
  
  
  
  
  Line line = new Line(200,100,200, 200);
  lines.add(line);
  
  line.evolve(1);
  line.display();
  for(int x = 0; x< lines.size();x++){
  lines.get(x).display();
  }
  
}
void draw(){
 
}