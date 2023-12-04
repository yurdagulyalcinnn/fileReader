import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        String ayrac = new String(new char[15]).replace("\0", "-");
        String okunanVeri;

        File dosya = new File("C:\\Users\\MSI-NB\\Desktop\\FileReader\\byte_tabanli_dosya.txt");
        File dosyaYaz = new File("C:\\Users\\MSI-NB\\Desktop\\FileReader\\byte_tabanli_dosya.txt");
        File hedefDosya = new File("C:\\Users\\MSI-NB\\Desktop\\hedef\\dosya.txt");

        Path kaynak = Paths.get("C:\\Users\\MSI-NB\\Desktop\\FileReader\\byte_tabanli_dosya.txt");
        Path hedef = Paths.get("C:\\Users\\MSI-NB\\Desktop\\hedef\\dosya.txt");


        try {

            // Dosya kopyalama
            System.out.println(ayrac + "\n< Dosya Kopyalama İşlemi >\n" + ayrac);
            Files.copy(kaynak, hedef, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Dosya başarıyla kopyalandı.");
// Dosya yazma işlemi
            System.out.println(ayrac + "\n< Java FileWriter Dosya Yazma İşlemi >\n" + ayrac);
            FileWriter yazdir1 = new FileWriter(dosyaYaz);
            yazdir1.write("Bu bir dosya yazdirma islemidir. Dosya aktarımı tamamlanmistir. :)");
            yazdir1.close();
            // Dosya taşıma
            System.out.println(ayrac + "\n< Dosya Taşıma İşlemi >\n" + ayrac);
            Files.move(kaynak, hedef, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Dosya başarıyla taşındı.");

            // Dosya yazma işlemi
            System.out.println(ayrac + "\n< Java FileWriter Dosya Yazma İşlemi >\n" + ayrac);
            FileWriter yazdir = new FileWriter(dosyaYaz);
            yazdir.write("Bu bir dosya yazdirma islemidir. Dosya aktarımı tamamlanmistir. :)");
            yazdir.close();


        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O hatası: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }


        try (FileReader fileReader = new FileReader(dosya);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            // Dosya okuma işlemleri
            System.out.println(ayrac + "\n< Java FileReader Dosya Okuma İşlemi >\n" + ayrac);
            char[] veriler = new char[(int) dosya.length()];
            fileReader.read(veriler);
            okunanVeri = new String(veriler);
            System.out.println(okunanVeri);

            System.out.println(ayrac + "\n< Java FileInputStream Dosya Okuma İşlemi >");
            FileInputStream fileInputStream = new FileInputStream(dosya);
            byte[] byteVeriler = new byte[(int) dosya.length()];
            fileInputStream.read(byteVeriler);
            okunanVeri = new String(byteVeriler);
            System.out.println(okunanVeri);

            System.out.println(ayrac + "\n< Java BufferedReader Dosya Okuma İşlemi >");
            while ((okunanVeri = bufferedReader.readLine()) != null) {
                System.out.println(okunanVeri);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O hatası: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
