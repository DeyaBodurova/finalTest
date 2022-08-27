package TrafficLights;

public class TrafficLight {
    private Colours currentColour;

    public TrafficLight (Colours currentColour){
        this.currentColour = currentColour;
    }

    public Colours getCurrentColour(){
        return currentColour;
    }

    public void changeColour() {
        switch (currentColour){
            case RED:
                this.currentColour = Colours.GREEN;
                break;
            case GREEN:
                this.currentColour = Colours.YELLOW;
                break;
            case YELLOW:
                this.currentColour = Colours.RED;
                break;
            default:
                throw new IllegalArgumentException("No such colour.");
        }
    }
}
