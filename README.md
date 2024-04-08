 

# Spring Boot Uygulamasının Kurulum ve Çalıştırılması Kılavuzu 

  

Bu belgede, Spring Boot , PostgreSQL ve Visual Studio Code kullanılarak geliştirilmiş bir projenin nasıl kurulacağı, çalıştırılacağı ve veritabanı üzerindeki verilere nasıl erişileceği adımları anlatılacaktır. 

Proje1, frontend kodlarını içerir ve `src/components` dizininde bulunur. 

Labo2 ise backend kodlarını içerir ve `src/main/java/proje/labo` dizininde yer alır.


  

## Kurulum Adımları 

  

### PostgreSQL Kurulumu ve Veritabanı Oluşturma: 

  

1. **PostgreSQL Kurulumu**:  

  

2. **Veritabanı Oluşturma**:  

   - PostgreSQL'e bağlanıldı ve istenen veritabanını oluşturuldu. 

   - Senaryoya göre, "raporlar" ve "laborantlar" tablolarını oluşturuldu ve veriler girildi. 
   -Proje kapsamında kullanılan veritabanı yapısını ve başlangıç verilerini aşağıda bulabilirsiniz.

## Tablolar

### `Raporlar` Tablosu

Bu tablo, hastaların raporlarını saklamak için kullanılır.

```sql
CREATE TABLE Raporlar (
  dosya_numarasi SERIAL PRIMARY KEY,
  hasta_ad VARCHAR(50),
  hasta_soyad VARCHAR(50),
  hasta_tc VARCHAR(11),
  tani_basligi VARCHAR(100),
  tani_detaylari TEXT,
  rapor_tarihi DATE,
  fiziksel_rapor_fotografi VARCHAR(100),
  laborant_id INT REFERENCES Laborantlar(laborant_id)
);

### Laborantlar` Tablosu

CREATE TABLE Laborantlar (
  laborant_id SERIAL PRIMARY KEY,
  ad VARCHAR(50),
  soyad VARCHAR(50),
  hastane_kimlik_numarasi INT
);

### Raporlar Tablosuna Veri Ekleme
INSERT INTO Raporlar ( hasta_ad, hasta_soyad, hasta_tc, tani_basligi, tani_detaylari, rapor_tarihi, fiziksel_rapor_fotografi, laborant_id
) VALUES
  ('Ahmet', 'Yılmaz', '27645678901', 'Migren', 'Baş ağrısı ve halsizlik şikayetleri mevcut.', '2024-01-25', 'dosya123.jpg', 1),
  ('Ayşe', 'Kaya', '27656789012', 'Grip', 'Ateş ve öksürük belirtileri bulundu.', '2024-03-25', 'dosya124.jpg', 2),
  ('Mehmet', 'Demir', '27667543570', 'Mide Ağrısı', 'Mide yanması ve hazımsızlık problemi var.', '2024-03-28', 'dosya125.jpg', 3),
  ('Fatma', 'Şahin', '27638901234', 'Şeker', 'Yüksek kan şekeri tespit edildi.', '2024-03-24', 'dosya126.jpg', 4),
  ('Selim', 'Çelik', '27689018345', 'Zehirlenme', 'Karın ağrısı ve kusma şikayetleri var.', '2024-03-21', 'dosya127.jpg', 5);

### Laborantlar Tablosuna Veri Ekleme

INSERT INTO Laborantlar (ad, soyad, hastane_kimlik_numarasi) VALUES
  ('Ali', 'Yıl', 1000001),
  ('Aişe', 'Kay', 1000002),
  ('Memo', 'Dem', 1000003),
  ('Fatıma', 'Şah', 1000004),
  ('Alin', 'Çelim', 1000005);



### Spring Boot Projesinin Oluşturulması: 

  

1. **Spring Initializr Kullanarak Proje Oluşturma**:  

   - [Spring Initializr] web sitesinden  Maven projesi olarak yeni bir proje oluşturuldu. 

   - Gerekli bağımlılıkları (Spring Web, Spring Data JPA, PostgreSQL Driver)  ve proje ayarlarını yapılandırdı. 

    

  

2. **IDE'ye Projenin İmport Edilmesi**:  

   - İndirilen proje dosyasını bir IDE'ye (Spring Tool Suite 4) import edildi. 

  

### Proje Paketlerinin Oluşturulması: 

  

1. **Controller Paketi Oluşturma**:  

   - API için bir controller paketi oluşturuldu. 

  

2. **Business Katmanı Paketleri Oluşturma**:  

   - İş katmanı için abstract ve concrete paketlerini oluşturuldu. 

   

3. **DataAccess Katmanı Paketleri Oluşturma**:  

   - Veritabanı işlemleri için abstract ve concrete paketlerini oluşturuldu. 

  

4. **Entity Katmanı Paketleri Oluşturma**:  

   - Veritabanı tablolarını temsil edecek abstract ve concrete paketlerini oluşturuldu. 

  

### React Kütüphanesinin Kurulumu: 

  

1. **React Kurulumu**:  

   - Visual Studio Code veya tercih ettiğiniz bir metin editörü kullanarak React kütüphanesini kuruldu. 

   - "components" dosyası içerisinde raporlar için gerekli bileşenleri oluşturuldu ve CSS özelliklerini eklendi. 

   - Backend'den veri almak için gerekli bağlantıları Axios ile kuruldu. 

  

## Teknik Seçimler ve Gerekçeleri 

  

- **PostgreSQL Veritabanı**:  

  - Güçlü ve güvenilir bir açık kaynaklı veritabanı yönetim sistemidir. 

  

- **Spring Tool Suite 4 (STS)**:  

  - Spring tabanlı uygulamaları geliştirmek için özel olarak tasarlanmış bir entegre geliştirme ortamıdır. 

  

- **Visual Studio Code**:  

  - Geniş eklenti desteği ve kullanım kolaylığıyla popüler bir metin editörüdür. 

 

 # Uygulama Nasıl Çalışır Hale Getirilir? 

  

## İDE Kullanmadan Çalıştırma: Terminal Komutları 

  

### Spring Boot İçin 

  

 

 

1. **Proje Dizinine Gitme**: 

   Terminal veya komut istemcisini kullanarak ilgili proje dizinine gidin.  

   cd Desktop 

  

2. **Uygulama JAR Dosyasının Bulunması**: 

   Proje dizinindeki JAR dosyasının adını kontrol edin. 

   ls 

  

3. **Uygulamayı Başlatma**: 

   JAR dosyasının adını belirledikten sonra, aşağıdaki komutu kullanarak Spring Boot uygulamasını başlatın: 

   java --jar labo.jar 



   Burada, `labo.jar`, derlenmiş Spring Boot uygulamasının JAR dosyasının adıdır. 

 

  

### Visual Studio Code İçin 

  

1. **Proje Dizinine Gitme**: 

   Visual Studio Code'u açın ve ilgili proje dizinine gidin. 

   cd laboProje/proje1 

    

 

 

2. **Axios kütüphanesini ekleme**: 

  npm i axios@latest 

 

  

3. **Uygulamayı Başlatma**: 

   Proje dizinindeyken, aşağıdaki komutu kullanarak uygulamayı başlatın: 

   

   npm run dev 

   

   Bu komut, genellikle React uygulamalarında geliştirme sunucusunu başlatır. Ancak, proje yapılandırmasına bağlı olarak değişebilir. 

  

### PostgreSQL Verilerine Erişim 

  

1. **psycopg2 Kütüphanesinin Kurulması**: 

   PostgreSQL veritabanına erişmek için  psycopg2 kütüphanesini kurmanız gerekmektedir. Kurulum için: 

 

   pip install psycopg2 



  

2. **PostgreSQL Veritabanına Bağlanma**: 

   PostgreSQL veritabanına bağlanmak için aşağıdaki komutu kullanın: 



   pgcli -h localhost -U postgres -d raporyonetimi 



   Burada, `localhost` PostgreSQL sunucu adresini, `postgres` PostgreSQL veritabanı kullanıcı adını ve `raporyonetimi` PostgreSQL veritabanı adını temsil eder. 

  

3. **Verilere Erişme**: 

   Bağlandıktan sonra, SQL sorgularını kullanarak PostgreSQL veritabanındaki verilere erişebilirsiniz. Örneğin: 



   SELECT * FROM raporlar; 

   SELECT * FROM laborantlar; 



   Bu sorgular, `raporlar` ve `laborantlar` tablolarındaki tüm verileri getirecektir. 

 

 

 

 

 
