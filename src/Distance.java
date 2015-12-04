
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Distance {
    private double distance;

    public Distance(){
    }

    public double distance(Point2D.Double one, Point2D.Double two){
        distance = Math.sqrt(Math.pow(Math.abs(one.x - two.x), 2) + Math.pow(Math.abs(one.y - two.y), 2));
        return distance;
    }
    public static void main(String[] args){
        Distance d = new Distance();
        Scanner scan = new Scanner(System.in);

        /** GET NUMBER OF VERTICES TO COMPUTE **/
        System.out.println("Enter the number of vertices: ");
        int numVertices = scan.nextInt();
        List<Point2D.Double> vertices = new ArrayList<>();

        /** GET VERTICES FROM USER **/
        for (int i = 1; i <= numVertices; i++) {
            System.out.println("Enter the x coordinate for V" + i);
            double x = scan.nextDouble();
            System.out.println("Enter the y coordinate for V" + i);
            double y = scan.nextDouble();
            vertices.add(new Point2D.Double(x,y));
        }

        /*************************************************************************************************************/

        /** VERIFY DATA ENTERED CORRECTLY **/
        System.out.println("\nThe data is entered as follows ");
        System.out.print("[ ");
        for ( int i = 0; i <= numVertices-1; i++) {
            System.out.print("V" + (i+1) + " ");
            System.out.print("[" + vertices.get(i).x + ", " + vertices.get(i).y + "]");
            //System.out.print("[" + vertices[i][0] + "," + vertices[i][1] + "]");
            if ( i != numVertices-1) {
                System.out.print("\n  ");
            }
        }
        System.out.println(" ]\n");

        /*************************************************************************************************************/

        /** CALCULATE DISTANCES & INSERT IN 2D ARRAY **/
        double[][] distances = new double[numVertices][numVertices];

        for (int k = 0; k <= numVertices-1; k++) {
            for (int i = 0; i <= numVertices-1; i++) {
                distances[k][i] = d.distance(vertices.get(k), vertices.get(i));
                //distances[k][i] = d.distance(vertices[i][0], vertices[i][1]) ;
            }
        }

        /*************************************************************************************************************

         System.out.println("The following table contains all combinations of vertices");

         for ( int i = 0; i <= numVertices-1; i++) {

         for ( int j = 0; j <= numVertices-1; j++) {

         System.out.print("V" + (i+1) + "[" + vertices.get(i).x + "," + vertices.get(i).y + "] and ");
         System.out.print("V" + (j+1) + "[" + vertices.get(j).x + "," + vertices.get(j).y + "] ");
         System.out.print("have a distance of " + String.format("%.5g", d.distance(vertices.get(i), vertices.get(j))));
         System.out.print("\n");
         }

         }
         System.out.println("\n");

         **************************************************************************************************************

         System.out.println("The 2D array contains the following values:");

         for (int k = 1; k <= numVertices-1; k++) {
         for (int i = 1; i <= numVertices-1; i++) {
         System.out.println("  " + String.format("%.5g", distances[k][i]));
         }
         }
         System.out.println("\n");

         *************************************************************************************************************/

        /*****************************************
         *  PRINT TABLE OF DISTANCES IN CONSOLE  *
         *****************************************/

        // ROW OF LABELS
        System.out.print("|         ");
        for (int i = 0; i <= numVertices - 1; i++) {

            System.out.print("|");
            System.out.print("    V" + (i+1) + "   ");
            if (i <= 8) {
                System.out.print(" ");
            }
            if (i == numVertices - 1) {
                System.out.print("|");
            }
        }

        // ROWS
        for ( int row = 0; row <= numVertices - 1; row++) {
            System.out.print("\n");
            System.out.print("|");
            System.out.print("   V" + (row+1) + "   ");
            if (row <= 8) {
                System.out.print(" ");
            }
            System.out.print("|");

            // COLUMNS
            for (int col = 0; col <= numVertices - 1; col++) {
                System.out.print("  " + String.format("%.5g", distances[row][col]) + " ");

                if (col <= 10) {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
        }
        System.out.println("\n");
        /*************************************************************************************************************/

        /** FIND MIN DISTANCE IN EACH ROW **/

        for (int row = 0; row < distances.length; row++) {
            double lowestValue = Double.MAX_VALUE; //, tempDouble;
            double curValue;

            for (int col = 0; col < distances[0].length; col++) {
                curValue = distances[row][col];
                if ((curValue < lowestValue) && (curValue != 0)) {
                    lowestValue = curValue;
                }
            }
            System.out.println("The lowest distance for V" + (row+1) + " is: " + String.format("%.4g",lowestValue));
        }

        /*************************************************************************************************************/

    } // end main
}
