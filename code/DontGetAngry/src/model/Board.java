package model;

public class Board {


	private Field[] track= new Field[40];
	private Field[] redGoal= new Field[4];
	private Field[] blueGoal= new Field[4];
	private Field[] greenGoal= new Field[4];
	private Field[] yellowGoal= new Field[4];


	public Board(){
		for(int i = 0;i<this.track.length;i++){
			this.track[i]=new Field(i+"");
		}
		this.redGoal[0]=new Field("AR");
		this.redGoal[1]=new Field("BR");
		this.redGoal[2]=new Field("CR");
		this.redGoal[3]=new Field("DR");
		this.blueGoal[0]=new Field("AB");
		this.blueGoal[1]=new Field("BB");
		this.blueGoal[2]=new Field("CB");
		this.blueGoal[3]=new Field("DB");
		this.greenGoal[0]=new Field("AG");
		this.greenGoal[1]=new Field("BG");
		this.greenGoal[2]=new Field("CG");
		this.greenGoal[3]=new Field("DG");
		this.yellowGoal[0]=new Field("AY");
		this.yellowGoal[1]=new Field("BY");
		this.yellowGoal[2]=new Field("CY");
		this.yellowGoal[3]=new Field("DY");
	}
	public void occupy(Pawn p){
		String pos = p.getPosition();
		for(int i=0;i<track.length;i++){
			if(pos.equalsIgnoreCase(track[i].getName())){
				track[i].setTakenBy(p.getColor());
			}
		}
		for(int i=0;i<redGoal.length;i++){
			if(pos.equalsIgnoreCase(track[i].getName())){
				redGoal[i].setTakenBy(p.getColor());
			}
		}
		for(int i=0;i<blueGoal.length;i++){
			if(pos.equalsIgnoreCase(track[i].getName())){
				blueGoal[i].setTakenBy(p.getColor());
			}
		}
		for(int i=0;i<greenGoal.length;i++){
			if(pos.equalsIgnoreCase(track[i].getName())){
				greenGoal[i].setTakenBy(p.getColor());
			}
		}
		for(int i=0;i<yellowGoal.length;i++){
			if(pos.equalsIgnoreCase(track[i].getName())){
				yellowGoal[i].setTakenBy(p.getColor());
			}
		}
	}
	public void occupy(String position, String owner){
		for(int i=0;i<track.length;i++){
			if(position.equalsIgnoreCase(track[i].getName())){
				track[i].setTakenBy(owner);
			}
		}
		for(int i=0;i<redGoal.length;i++){
			if(position.equalsIgnoreCase(track[i].getName())){
				redGoal[i].setTakenBy(owner);
			}
		}
		for(int i=0;i<blueGoal.length;i++){
			if(position.equalsIgnoreCase(track[i].getName())){
				blueGoal[i].setTakenBy(owner);
			}
		}
		for(int i=0;i<greenGoal.length;i++){
			if(position.equalsIgnoreCase(track[i].getName())){
				greenGoal[i].setTakenBy(owner);
			}
		}
		for(int i=0;i<yellowGoal.length;i++){
			if(position.equalsIgnoreCase(track[i].getName())){
				yellowGoal[i].setTakenBy(owner);
			}
		}
	}
	public Field[] getTrack() {
		return track;
	}
	public String checkField(String pos){
		for(int i=0;i<track.length;i++){
			if(track[i].getName().equalsIgnoreCase(pos)){
				return track[i].getTakenBy();
			}
		}
		for(int i=0;i<redGoal.length;i++){
			if(redGoal[i].getName().equalsIgnoreCase(pos)){
				return redGoal[i].getTakenBy();
			}
		}
		for(int i=0;i<blueGoal.length;i++){
			if(blueGoal[i].getName().equalsIgnoreCase(pos)){
				return blueGoal[i].getTakenBy();
			}
		}
		for(int i=0;i<greenGoal.length;i++){
			if(greenGoal[i].getName().equalsIgnoreCase(pos)){
				return greenGoal[i].getTakenBy();
			}
		}
		for(int i=0;i<yellowGoal.length;i++){
			if(yellowGoal[i].getName().equalsIgnoreCase(pos)){
				return yellowGoal[i].getTakenBy();
			}
		}
		return "false position";
	}
	public void setTrack(Field[] track) {
		this.track = track;
	}
	public Field[] getRedGoal() {
		return redGoal;
	}
	public void setRedGoal(Field[] redGoal) {
		this.redGoal = redGoal;
	}
	public Field[] getBlueGoal() {
		return blueGoal;
	}
	public void setBlueGoal(Field[] blueGoal) {
		this.blueGoal = blueGoal;
	}
	public Field[] getGreenGoal() {
		return greenGoal;
	}
	public void setGreenGoal(Field[] greenGoal) {
		this.greenGoal = greenGoal;
	}
	public Field[] getYellowGoal() {
		return yellowGoal;
	}
	public void setYellowGoal(Field[] yellowGoal) {
		this.yellowGoal = yellowGoal;
	}

}
