public class Solution {
    public String simplifyPath(String path) 
    {
        
        String[] palabras = path.split("/");
 
        
        List<String> respuesta = new ArrayList<>();
 
        
        for (String palabra : palabras) 
        {
    
            if (palabra.equals("..")) 
            {
                if (!respuesta.isEmpty())  
                    respuesta.remove(respuesta.size() - 1);
                continue;
            }
 
             
            if (!palabra.equals("") && !palabra.equals(".")) 
            {
                respuesta.add(palabra);
            }
        }
 
        //paso#4
        return "/" + String.join("/", respuesta);
    }
}
