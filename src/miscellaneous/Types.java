package miscellaneous;

/*type inference (var): types are not dynamic, it is defined in compilation stage (not the runtime)
don't work with null and the classes fields (only local variables)
 */
class Types {
    public static void main(String[] args) {
        int num_1 = 10;
        String type_1 = ((Object) num_1).getClass().getName(); //output is string
        System.out.println(type_1);

        var num_2 = 10; //type is not dynamic - it is defined in compilation
        var type_2 = ((Object) num_2).getClass(); //(Object) = auto-packaging, because getClass() don't work with primitives

        var str = "String";
        var type_str = str.getClass(); //with wrapper-class we can use getClass()
        if (str instanceof String) System.out.println(type_str); //compare in the runtime, not in compilation

    }
}
