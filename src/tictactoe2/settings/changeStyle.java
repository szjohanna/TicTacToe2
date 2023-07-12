
package tictactoe2.settings;

public class changeStyle {
   
    public static String cssPath = "/tictactoe2/css/stylesheets/beigeStylesheet.css";
    
    private static String style = "Choose Style";

    public static String getStyle() {
        return style;
    }

    public static void setStyle(String style) {
        changeStyle.style = style;
    }
    
}
