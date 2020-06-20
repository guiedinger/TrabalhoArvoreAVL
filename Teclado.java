import java.io.*;

/** Classe que permite fazer leitura de dados do teclado */

public class Teclado
{
     private String s;
     private InputStreamReader i = new InputStreamReader (System.in);
     private BufferedReader d = new BufferedReader(i);

     public int leInt ()
     {   int a = 0;
         try
         {
             s = d.readLine();
             a = Integer.parseInt(s);
         }
         catch (IOException e)
         {
             System.out.println ("Erro de I/O: " + e);
         }
         catch (NumberFormatException e)
         {
             System.out.println ("o valor digitado deve ser inteiro: "+e );
         }
         return (a);
     }

     public int leInt (String msg)
     {   int a = 0;
         System.out.println(msg);
         try
         {
             s = d.readLine();
             a = Integer.parseInt(s);
         }
         catch (IOException e)
         {
             System.out.println ("Erro de I/O: "+e );
         }
         catch (NumberFormatException e)
         {
             System.out.println ("o valor digitado deve ser inteiro: "+e );
         }
         return (a);
     }
     
     public double leDouble()
     {   double a = 0;
         try
         {
             s = d.readLine();
             a = Double.parseDouble(s);
         }
         catch (IOException e)
         {
             System.out.println ("Erro de I/O: " + e);
         }
         catch (NumberFormatException e)
         {
             System.out.println ("o valor digitado deve ser n�mero: "+e );
         }
         return (a);
     }

     public double leDouble(String msg)
     {   double a = 0;
         System.out.println(msg);
         try
         {
             s = d.readLine();
             a = Double.parseDouble(s);
         }
         catch (IOException e)
         {
             System.out.println ("Erro de I/O: " + e);
         }
         catch (NumberFormatException e)
         {
             System.out.println ("o valor digitado deve ser numero: "+e );
         }
         return (a);
     }
     
     public String leString()
     {   s = "";
         try
         {
            s = d.readLine();
         }
         catch (IOException e)
         {
            System.out.println ("Erro de I/O: " + e);
         }
         return (s);
     }

     public String leString(String msg)
     {   s = "";
         System.out.println(msg);
         try
         {
            s = d.readLine();
         }
         catch (IOException e)
         {
            System.out.println ("Erro de I/O: " + e);
         }
         return (s);
     }
     
     public char leChar()
     {   char a = ' ';
         try
         {
             s = d.readLine();
             a = s.charAt(0);
         }
         catch (IOException e)
         {
             System.out.println ("Erro de I/O: " + e);
         }
         catch (NumberFormatException e)
         {
             System.out.println ("o valor digitado deve ser char: "+e );
         }
         return (a);
     }

     public char leChar(String msg)
     {   char a = ' ';
         System.out.println(msg);
         try
         {
             s = d.readLine();
             a = s.charAt(0);
         }
         catch (IOException e)
         {
             System.out.println ("Erro de I/O: " + e);
         }
         catch (NumberFormatException e)
         {
             System.out.println ("o valor digitado deve ser um char: "+e );
         }
         return (a);
     }
}
