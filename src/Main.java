import modelo.Avion;
import modelo.AvionComercial;
import modelo.AvionDeCombate;

public class Main {

    //ejemplos con aviones
    public static void main(String[] args)
    {
        Avion aCombate = new AvionDeCombate();
        Avion aComercial = null;

        try
        {
            System.out.println("ESTO ES EL TRY");
            errorSinElevar(); //no aparece este error porque tiene un try y se captura dentro del metodo
            System.out.println("esto se muestra porque todavia no hay errores\n");

           // errorConThrow();
            errorElevado(); //metodo con error, se eleva al catch que tengo aca en el main


            aComercial = (AvionComercial)aCombate; //este casteo da un Exception
            aComercial.toString();

            System.out.println("TRY DESPUES");
        }



        //si ocurre el Exception entonces el control es del catch -->

        catch (ClassCastException cce)
        {
            System.out.println("--> Error en la asignacion");
        }

        catch (ArithmeticException ae)
        {
            System.out.println(ae.getMessage());
            System.out.println("--> Error aritmetico");
        }

        catch (Exception e)
        {
            System.out.println("ESTO ES EL CATCH, ocurrio un error");

            //mensajes para los programadores
            e.printStackTrace(); //muestra el Exception al final de la ejecucion
            System.out.println(e.getMessage()); // muestra cual fue el error "ej: xclass cannot be cast to yclass"
            System.out.println("--> Otro error no se cual");
        }

        finally {
            System.out.println("\nESTO ES EL FINALLY: se ejecuta haya o no errores\n");
        }

       // aComercial.toString(); es null aca, ocurre un error, pongo las sentencias conflictivas en el try
        //tengo que ver en que clase ocurre la excepcion


        try {
            ingresarContrasena(222);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static void errorSinElevar() //ej de metodo con un error manejado con try
    {
        try {
            int a = 0/0;
        }catch (Exception e)
        {
            e.getMessage();
        }
    }

    public static void errorElevado ()
    {
        int a = 0/0;
    }



    //ejemplo de lanzar un throw (no tiene mucho sentido)
    public static void ingresarContrasena (int contrasena) throws Exception //indica que se tiene que capturar el metodo donde se llame
    {
        if (contrasena != 123)
        {
            throw new Exception("Contrasena incorrecta"); //siempre que hago throw new lo pongo en la firma (cabecera del metodo)
        }
    }


}