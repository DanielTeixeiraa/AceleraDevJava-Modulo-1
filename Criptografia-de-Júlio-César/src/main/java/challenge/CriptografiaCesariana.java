package challenge;

public class CriptografiaCesariana implements Criptografia {
    public int chave = 3;

    @Override
    public String criptografar(String texto) {
        return criptografia(texto, 3);
    }

    @Override
    public String descriptografar(String texto) {
        return criptografia(texto, -3);
    }

    public String criptografia(String texto, int chave) {
        StringBuffer textoFinal = new StringBuffer();
        validarTexto(texto);
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isLetter(texto.charAt(i))) {
                if (Character.isUpperCase(texto.charAt(i))) {
                    char ch = (char) (((int) texto.charAt(i) + chave - 65) % 26 + 65);
                    textoFinal.append(ch);
                } else {
                    char ch = (char) (((int) texto.charAt(i) + chave - 97) % 26 + 97);
                    textoFinal.append(ch);
                }
            } else {
                textoFinal.append(texto.charAt(i));
            }
        }
        return textoFinal.toString().toLowerCase();
    }

    private void validarTexto(String texto) throws IllegalArgumentException {
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("Texto invalido");
        }
    }

}

