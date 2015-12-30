
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

  void transform(){
    
  }
  void display(){
    PVector end= PVector.add(point, vector);
    line(point.x, point.y, end.x, end.y);
  }
  
}