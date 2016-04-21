package mx.edu.utng.manualhtml5;
public class Question {
    /**
     * variables
     */
    private int ID;
    private String PREGUNTA;
    private String OPCIONA;
    private String OPCIONB;
    private String OPCIONC;
    private String RESPUESTA;

    /**
     * poner en cero el contenido
     */
    public Question()
    {
        ID=0;
        PREGUNTA="";
        OPCIONA="";
        OPCIONB="";
        OPCIONC="";
        RESPUESTA="";
    }

    public Question(String pREGUNTA, String oPCIONA, String oPCIONB, String oPCIONC, String rESPUESTA) {

        PREGUNTA = pREGUNTA;
        OPCIONA = oPCIONA;
        OPCIONB = oPCIONB;
        OPCIONC = oPCIONC;
        RESPUESTA = rESPUESTA;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPREGUNTA() {
        return PREGUNTA;
    }

    public void setPREGUNTA(String PREGUNTA) {
        this.PREGUNTA = PREGUNTA;
    }

    public String getOPCIONA() {
        return OPCIONA;
    }

    public void setOPCIONA(String OPCIONA) {
        this.OPCIONA = OPCIONA;
    }

    public String getOPCIONB() {
        return OPCIONB;
    }

    public void setOPCIONB(String OPCIONB) {
        this.OPCIONB = OPCIONB;
    }

    public String getOPCIONC() {
        return OPCIONC;
    }

    public void setOPCIONC(String OPCIONC) {
        this.OPCIONC = OPCIONC;
    }

    public String getRESPUESTA() {
        return RESPUESTA;
    }

    public void setRESPUESTA(String RESPUESTA) {
        this.RESPUESTA = RESPUESTA;
    }


    public int getID() {
        return ID;
    }


}
