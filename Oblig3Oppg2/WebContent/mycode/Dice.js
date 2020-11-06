 
class Dice {
 
	contructor(value=null){
		this.value = value; 
	}
	
	roll(){
		this.value = Math.floor(Math.random() * 6) +1;
	}
}