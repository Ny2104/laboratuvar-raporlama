 

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

 

 

 

 

 
