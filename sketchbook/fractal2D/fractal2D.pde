
ArrayList<Line> lines = new ArrayList<Line>(100);
void evolve(Line line,int count){
  //line.vector.mult
  PVector point = PVector.add(line.point, PVector.mult(line.vector, 0.5));
  PVector subPoint1 = PVector.add(line.point, PVector.mult(line.vector, 0.25)); 
  
  
  PVector gap = new PVector(line.vector.y*0.5, line.vector.x*0.5);
  PVector lines1 = PVector.add(subPoint1, gap);
  Line first = new Line(line.point, lines1);
  PVector startPoint = PVector.add(line.point, lines1);
  
  PVector lines2 = PVector.sub(point, startPoint);
  Line second = new Line(startPoint, lines2);
  Line third = new Line(point, lines1);
  PVector secondStart = PVector.add(startPoint,line.vector.mult(0.5));
  Line fourth = new Line(secondStart, lines2);
  
  lines.add(first);
  lines.add(second);
  lines.add(third);
  lines.add(fourth);
}
int dgdrsdchfg=230;
void setup(){
  size(500,500);
  
  
  
  
  Line line = new Line(400,200,-300, 0);
  line.display();
  
  evolve(line, 0);
  lines.get(0).display();
  lines.get(1).display();
  lines.get(2).display();
  lines.get(3).display();
  
}
void draw(){
 
}