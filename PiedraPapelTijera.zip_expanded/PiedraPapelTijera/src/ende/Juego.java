package ende;

/**
 * Simula el juego de Piedra, Papel o tijera
 */


public class Juego 
{
    public static void main(String args[])
    {
        Jugador p1=new Jugador();
        Jugador p2=new Jugador();
        boolean fin_de_juego=false;  
        Integer Rondasjugadas = 0;    // N�mero de rondas jugadas
        Integer EXITOS_jugador1=p1.�xitos;
        Integer EXITOS_jugador2=p2.�xitos;
        Integer EmPaTeS = 0;
        String opcion_JUGADOR1, opcion_JUGADOR2;
        
        // Bucle de juego
        do
        {
            System.out.println("***** Ronda: " + Rondasjugadas+" *********************\n");
            System.out.println("Numero de empates: "+ EmPaTeS + "\n");
            opcion_JUGADOR1=p1.opcion_al_azar();
            System.out.println("Jugador 1: " + opcion_JUGADOR1+"\t Jugador 1 - Partidas ganadas: " + EXITOS_jugador1);
            opcion_JUGADOR2 = p2.opcion_al_azar();
            System.out.println("Jugador 2: " + opcion_JUGADOR2+"\t Jugador 2 - Partidas ganadas: " + EXITOS_jugador2);
            
            if((opcion_JUGADOR1.equals("piedra"))&&(opcion_JUGADOR2.equals("papel")))
            {
                Jugador2Gana();
                EXITOS_jugador2 = ExitosJugador2(p2);
                
            }
            else if((opcion_JUGADOR1.equals("papel"))&&(opcion_JUGADOR2.equals("piedra")))
            {
            	EXITOS_jugador1 = ExitosJugador2(p1);
                jugador1Gana();
            }
            else if((opcion_JUGADOR1.equals("piedra"))&&(opcion_JUGADOR2.equals("tijeras")))
            {
            	EXITOS_jugador1 = ExitosJugador2(p1);
            	jugador1Gana();
            }
            else if((opcion_JUGADOR1.equals("tijeras"))&&(opcion_JUGADOR2.equals("piedra")))
            {
            	EXITOS_jugador2 = ExitosJugador2(p2);
                Jugador2Gana();
            }
            else if((opcion_JUGADOR1.equals("tijeras"))&&(opcion_JUGADOR2.equals("papel")))
            {
            	EXITOS_jugador1 = ExitosJugador2(p1);
            	jugador1Gana();
            }
            else if((opcion_JUGADOR1.equals("papel"))&&(opcion_JUGADOR2.equals("tijeras")))
            {
            	EXITOS_jugador2 = ExitosJugador2(p2);
                Jugador2Gana();
            }
            if(opcion_JUGADOR1==opcion_JUGADOR2)
            {
            	EmPaTeS++;
                System.out.println("\n\t\t\t Empate \n");
            }
            Rondasjugadas++;
            if((p1.�xitos>=3)||(p2.�xitos>=3))
            {
            	fin_de_juego=true;
                System.out.println("FIN DEL JUEGO!!");
            }
            System.out.println();
        } while(fin_de_juego!=true);
    }
    private static void jugador1Gana() {
		System.out.println("Jugador 1 GANA");
	}

	private static void Jugador2Gana() {
		System.out.println("Jugador 2 GANA");
	}

	private static Integer ExitosJugador2(Jugador p2) {
		Integer EXITOS_jugador2;
		EXITOS_jugador2 = ++p2.�xitos;
		return EXITOS_jugador2;
	}
}
/**
 *
 */
class Jugador{
   
    /**
     * Escoge piedra, papel o tijera al azar
     */
    public String opcion_al_azar()
    {
        String opcion="";
        Integer c = (int)(Math.random()*3);
        switch(c){
            case 0:
            	opcion=("piedra");
                break;
            case 1:
            	opcion=("papel");
                break;
            case 2:
            	opcion=("tijeras");
        }
        return opcion;
    }
    public void set�xitos() 
    {
        �xitos++;
    }
    public int get�xitos() 
    {
        return(�xitos);
    }
    
    int �xitos;      // n�mero de partidas ganadas
    int winTotal;
}