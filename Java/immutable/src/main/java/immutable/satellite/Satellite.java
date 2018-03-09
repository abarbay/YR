package immutable.satellite;

public class Satellite {
    private CelestialCoordinates destinationCoordinates;
    private final String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent){
        if(isEmpty(registerIdent) || registerIdent==null){
            throw new IllegalArgumentException("Register ident must not be empty!");
        }
        this.registerIdent=registerIdent;
        this.destinationCoordinates=destinationCoordinates;


    }
    public void modifyDestination(CelestialCoordinates diff){
        if(diff==null){throw  new IllegalArgumentException("Difference cannot be 0!");}
        int  newX=destinationCoordinates.getX()+diff.getX();
        int  newY=destinationCoordinates.getY()+diff.getY();
        int  newZ=destinationCoordinates.getZ()+diff.getZ();
        destinationCoordinates= new CelestialCoordinates(newX,newY,newZ);
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    @Override
    public String toString() {
        return registerIdent+": "+ destinationCoordinates;
    }

    private boolean isEmpty(String str){
        boolean result=false;
        if(str==""){
            result=true;
        }
        return result;
    }
}
