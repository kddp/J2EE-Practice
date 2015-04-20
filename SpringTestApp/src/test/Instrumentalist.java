package test;

public class Instrumentalist implements Performer
{
	private Instrument instrument;
	private String name;
	
	public void perform() throws PerformanceException 
	{
		System.out.println("Instrumentalist having name =>"+name+" playing......");
		instrument.play();
	}
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
