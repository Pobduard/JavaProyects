public class func {
    String name;
    String last_name;
    int age;
    float height;
    double weight;
    char sex;

    /**
     * 
     */
    func(){
        this.name = null;
        this.last_name = null;
        this.age = 0;
        this.height = 0;
        this.weight = 0;
        this.sex = ' ';
    }

    func(String this_name, String this_las_name, int this_age, float this_height, double this_weight, char this_sex){
        this.name = this_name;
        this.last_name = this_las_name;
        this.age = this_age;
        this.height = this_height;
        this.weight = this_weight;
        this.sex = this_sex;
    }

    public func[] enlarge_arr_func(func[] arr){
        func[] auxiliar = new func[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            auxiliar[i] = arr[i];
        }
        return auxiliar;
    }
}
