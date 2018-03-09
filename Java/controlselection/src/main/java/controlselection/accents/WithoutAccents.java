package controlselection.accents;

public class WithoutAccents {
    public char convertToCharWithoutAccents(char c){
        switch(c){
            case 'á': return 'a';
            case 'é': return 'e';
            case 'í': return 'i';
            case 'ö': return 'o';
            case 'ő': return 'o';
            case 'ú': return 'u';
            case 'ű': return 'u';
            case 'Á': return 'A';
            case 'É': return 'E';
            case 'Í': return 'I';
            case 'Ö': return 'O';
            case 'Ő': return 'O';
            case 'Ú': return 'U';
            case 'Ű': return 'U';
            default: return c;
        }
    }
}
