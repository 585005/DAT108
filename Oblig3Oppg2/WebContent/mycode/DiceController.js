		
class DiceController {
	
	constructor(root = null) {
		this.run = this.run.bind(this);
		this.rollDice = this.rollDice.bind(this);
		this.root = root;
	}
  
  rollDice(){
		const dice = new Dice();
		dice.roll();
		var value = dice.value;
		const outRef = document.getElementById(this.root).querySelector("*[data-diceoutput]");
        outRef.innerHTML = value;
	}
	
	run(){
		const btRef = document.getElementById(this.root).querySelector("*[data-dicebutton]"); //creates a variable , getting the element with the id of data-dicebutton. connected to the button 
		btRef.addEventListener("click",this.rollDice,true); //to roll the dice, needs to tie the method, when you click on the button 
	}
	}
	