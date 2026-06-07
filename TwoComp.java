public class TwoComp {
    public static void main(String[] args) {
        String bi = "0110";
        String tcomp = "";
        int firstone = bi.lastIndexOf('1');
        for (int i = bi.length() - 1; i >= 0; i--) {
            if (i >= firstone) {
                tcomp = bi.charAt(i) + tcomp;

            } else if ((i < firstone)) {
                if (bi.charAt(i) == '1') {
                    tcomp = '0' + tcomp;
                } else {
                    tcomp = '1' + tcomp;
                }
            }
        }
        System.out.println(tcomp);
    }

}
