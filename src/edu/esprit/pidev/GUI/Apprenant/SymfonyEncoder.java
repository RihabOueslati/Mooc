/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.GUI.Apprenant;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;
/**
 *
 * @author pc
 */
public class SymfonyEncoder
{
 
/*
    README:
        // Initialisation
        SymfonyEncoder se = new SymfonyEncoder("MD5");
        
        // Inscription
        System.out.println("Exemple inscription: ");
        se.setPass_clair("123456");
        se.genererSalt();
        se.crypterPass();
        System.out.println("[!] Salt : "+se.getSalt());
        System.out.println("[!] Mot de passe crypté: "+se.getPass_crypte());
        
        // Authentification
        System.out.println("\nExemple authentification: ");
        se.setSalt("e1d8qzpyg88osswkcgocsosk44kw88w");
        se.setPass_clair("123456");
        se.crypterPass();
        System.out.println("[!] Mot de passe crypté: "+se.getPass_crypte());
        System.out.println("[!] la valuer valide est iz0DkVrVMhCCgEvjeMGoRA==");
        if ( se.comparerAvec("iz0DkVrVMhCCgEvjeMGoRA=="))
        {
            System.out.println("[+] Mot de passe correct");
        }
        else
        {
            System.out.println("[-] Mot de passe incorrect");
        }
*/
    private String Encodeur;
    private String Salt;
    private String pass_clair;
    private String pass_crypte;

    public SymfonyEncoder() {
    }

    public SymfonyEncoder(String Encodeur) {
        this.Encodeur = Encodeur;
    }

    public SymfonyEncoder(String Encodeur, String Salt) {
        this.Encodeur = Encodeur;
        this.Salt = Salt;
    }

    public SymfonyEncoder(String Encodeur, String Salt, String pass_clair) {
        this.Encodeur = Encodeur;
        this.Salt = Salt;
        this.pass_clair = pass_clair;
    }

    public SymfonyEncoder(String Encodeur, String Salt, String pass_clair, String pass_crypte) {
        this.Encodeur = Encodeur;
        this.Salt = Salt;
        this.pass_clair = pass_clair;
        this.pass_crypte = pass_crypte;
    }

    public String getEncodeur() {
        return Encodeur;
    }

    public void setEncodeur(String Encodeur) {
        this.Encodeur = Encodeur;
    }

    public String getSalt() {
        return Salt;
    }

    public void setSalt(String Salt) {
        this.Salt = Salt;
    }

    public String getPass_clair() {
        return pass_clair;
    }

    public void setPass_clair(String pass_clair) {
        this.pass_clair = pass_clair;
    }

    public String getPass_crypte() {
        return pass_crypte;
    }

    public void setPass_crypte(String pass_crypte) {
        this.pass_crypte = pass_crypte;
    }

    private String mt_rand() {
        Random generator = new Random();
        int r1 = generator.nextInt();
        return Integer.toString(r1);
    }

    private String base_convert(final String inputValue, final int fromBase, final int toBase) {
        return new BigInteger(inputValue, fromBase).toString(toBase);
    }

    private String uniqid(String prefix, boolean more_entropy) {
        long time = System.currentTimeMillis();
        String uniqid = "";
        if (!more_entropy) {
            uniqid = String.format("%s%08x%05x", prefix, time / 1000, time);
        } else {
            SecureRandom sec = new SecureRandom();
            byte[] sbuf = sec.generateSeed(8);
            ByteBuffer bb = ByteBuffer.wrap(sbuf);

            uniqid = String.format("%s%08x%05x", prefix, time / 1000, time);
            uniqid += "." + String.format("%.8s", "" + bb.getLong() * -1);
        }
        return uniqid;
    }

    private String sha1(String txt) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-512");
            md.reset();
            md.update(txt.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02X", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("SymfonyEncoder/sha1 : encodeur inexistant");
        }
        return null;
    }

    private byte[] encoder_byte(byte[] bytes) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(this.getEncodeur());
            md.reset();
            md.update(bytes);
            return md.digest();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("SymfonyEncoder/encoder_byte : l'encodeur " + this.getEncodeur() + " inexistant ou non supporté");
        }
        return null;
    }

    /**
     * generer le salt utilisé pour crypter le mot de passe 
     * fonction originale
     * 
     * <? base_convert(sha1(uniqid(mt_rand(), true)), 16, 36); ?>
     *
     * @return
     */
    public String genererSalt() {
        setSalt(base_convert(sha1(uniqid(mt_rand(), true)), 16, 36));
        return getSalt();
    }

    /**
     * crypter le mot de passe en utilisant l'alogorithme de Symfony2 le mot de
     * passe à crypter ==> pass_clair 
     * le resultat ==> pass_crypte 
     * fonction originale 
     * 
     * <? $salted = $mon_pass.'{'.$monsalt.'}'; $digest = hash('md5',
     * $salted, true); for ($i=1; $i<5000; $i++) { $digest = hash('md5',
     * $digest.$salted, true); echo $digest.'<br>'; } $encodedPassword =
     * base64_encode($digest); ?>
     *
     * 
     * @return
     */
    public String crypterPass() {
       String salted;
        salted = getPass_clair() + '{' + getSalt() + '}';

        byte[] salted_bytes = salted.getBytes();
        byte[] digest = encoder_byte(salted.getBytes());

        for (int i = 1; i < 5000; i++) {
            byte[] tmp = new byte[digest.length + salted_bytes.length];
            System.arraycopy(digest, 0, tmp, 0, digest.length);
            System.arraycopy(salted_bytes, 0, tmp, digest.length, salted_bytes.length);
            digest = encoder_byte(tmp);
        }
        Base64.Encoder e = Base64.getEncoder();
        this.setPass_crypte(new String(e.encode(digest)));
        return getPass_crypte();
    }
    
    /**
     * comparer le mot de passe crypter avec le mot de passe donné en parametres
     * @param pass
     * @return
     */
    public boolean comparerAvec(String pass)
    {
        return pass.equals(pass_crypte);
    }
}


