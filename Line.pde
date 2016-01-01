
class Line{
 PVector point; 
 PVector vector;

 
  Line(float x1,float y1,float x2,float y2){
    point = new PVector(x1,y1);
    vector = new PVector(x2, y2);  
  }
  
  Line(PVector point, PVector vector){
    this.point = point;
    this.vector = vector; 
  }

  
  void display(){
    PVector end= PVector.add(point, vector);
    line(point.x, point.y, end.x, end.y);
  }
  
  void evolve(int count){
   if(count>0){
  //line.vector.mult
  PVector point2 = PVector.add(point, PVector.mult(vector, 0.5));
  PVector subPoint1 = PVector.add(point, PVector.mult(vector, 0.25)); 
  
  
  PVector gap = new PVector(vector.y, -vector.x);
  gap.normalize();
  //float gapping
  gap.mult((vector.mag()/2)*(sqrt(3)/2));
  PVector startPoint = PVector.add(subPoint1,gap );
  PVector lines1 = PVector.sub( startPoint,point);
  Line first = new Line(point, lines1.get());
  
  
  PVector lines2 = PVector.sub(point2, startPoint);
  Line second = new Line(startPoint, lines2.get());
  Line third = new Line(point2, lines1.get());
  PVector secondStart = PVector.add(startPoint,vector.mult(0.5));
  Line fourth = new Line(secondStart, lines2.get());
  lines1 = null;
  lines2 = null;

  
  
  count--;
  //first.vector.mag()>=1
  
    first.evolve(count);
    second.evolve(count);
    third.evolve(count);
    fourth.evolve(count);
    
 }else{
   display();
   //print(count);

 }
  }
}
  