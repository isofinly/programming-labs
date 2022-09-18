public class Main {

//{19, 17, 15, 13, 11, 9, 7, 5, 3, 1}

// first task
public static int sum_var = 19;
public static final long[] single_dim_array_d = new long[10];
public static void first_task() {
    for (int i = 0; i < 10; i++) {
        single_dim_array_d[i] += sum_var;
        sum_var -= 2;
        System.out.print(single_dim_array_d[i] + " ");
            }
        System.out.println();
        }
// second task
        public static final float[] single_dim_array_x = new float[16];
        public static void second_task() {
            for (int i = 0; i < single_dim_array_x.length; i++) {
                single_dim_array_x[i] = (float) (-5 + (Math.random() * (29)));
            }
            for (int i = 0; i < single_dim_array_x.length; i++) {
                if (single_dim_array_x[i] > 14) {
                    single_dim_array_x[i] -= 10;
                };
                System.out.printf("%.2f ", (single_dim_array_x[i]));
            }
            System.out.println();
        }
//        third task
public static final double[][] two_dim_array = new double[8][16];
public static void third_task() {
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 16; j++) {
            if (single_dim_array_d[i] == 15) {
                two_dim_array[i][j] = Math.pow((Math.pow((Math.tan(single_dim_array_x[j]) / 4),3)),
                        (0.5 * ((Math.pow((0.75 + Math.tan(single_dim_array_x[j])), 2)) - 4)));
            } else if (single_dim_array_d[i] == 7 || single_dim_array_d[i] == 9
                    || single_dim_array_d[i] == 11 || single_dim_array_d[i] == 13) {
                two_dim_array[i][j] = Math.sin(Math.sin(Math.tan(single_dim_array_x[j])));
            } else {
                two_dim_array[i][j] = ((1 + Math.cbrt(Math.pow(Math.E, (single_dim_array_x[j] / 4))))
                        / (Math.pow(Math.E, (2 / (1 + 3 * single_dim_array_x[j])))));
            }
//            if (two_dim_array[i][j] != (1.0 / 0.0) & two_dim_array[i][j] != (-1.0 / 0.0) & (
//                    two_dim_array[i][j] > 0 || two_dim_array[i][j] <= 0)) {
                System.out.printf("%.2f ", two_dim_array[i][j]);
//            }
        }
    }
}
public static void main(String[] args){
    first_task();
    second_task();
    third_task();
    }
}

// System.out.println(Math.sin(Math.sin(Math.tan(op_1))));
// System.out.println((1 + Math.cbrt(Math.pow(Math.E,(op_1/4))))/(Math.pow(Math.E,(2/(1+3*op_1)))));
// System.out.println(Math.pow((Math.pow((Math.tan(op_1)/4),3)),(0.5 * ((Math.pow((0.75+Math.tan(op_1)),2))-4))));

/*
    .'`'.'`'.
.''.`.  :  .`.''.
'.    '. .'    .'
.```  .' '.  ```.
'..',`  :  `,'..'
     `-'`'-`))
            ((    java
             \|
 */
