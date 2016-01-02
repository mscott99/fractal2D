
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
  PVector pointStartSlope = PVector.add(point, PVector.mult(vector, 0.333));
  PVector pointEndSlope = PVector.add(point, PVector.mult(vector, 0.667));
  
  PVector gap = new PVector(vector.y, -vector.x);
  gap.normalize();
  //float gapping
  gap.mult((vector.mag()/3)*(sqrt(3)/2));
  PVector startPoint = PVector.add(point2,gap );
  PVector lines1 = PVector.mult(vector.get(), 0.333);
  Line first = new Line(point, lines1);
  
  
  PVector lines2 = PVector.sub( startPoint,pointStartSlope);
  PVector lines3 = PVector.sub(pointEndSlope, startPoint);
 Line second = new Line(pointStartSlope, lines2.get());
  Line third = new Line(startPoint, lines3.get());
  PVector secondStart = PVector.add(startPoint,PVector.mult(vector,0.5));
  Line fourth = new Line(pointEndSlope, lines1.get());
  

  
  
  
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


  