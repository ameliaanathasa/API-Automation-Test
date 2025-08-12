### Deskripsi ###
Proyek ini merupakan bagian dari Praktikum Mata Kuliah Pengujian Perangkat Lunak yang bertujuan untuk mempelajari API Testing dengan pendekatan otomatisasi menggunakan Maven. Dalam praktikum ini, digunakan data dummy dari https://dummyapi.io/docs, khususnya menggunakan User Data API. 

### Tujuan ###
- Memahami konsep dasar API Testing
- Mempelajari penggunaan Maven untuk automation testing
- Menggunakan data dummy dari DummyAPI untuk pengujian
- Melakukan pengujian pada data user menggunakan method PUT.

### Build with / Teknologi ###
Proyek pengujian API otomatis ini dibangun dengan melibatkan dua library :
- REST Assure
- TestNG

### Prerequisite ###
Untuk menjalankan proyek pengujian ini, diperlukan beberapa equipment sebagai persiapan environment proyek :
- Bahasa pemrograman : JDK versi 11
- Build Tool : Apache Maven
- IDE : Intellij IDEA

### Instalasi ###
1. Clone repository dengan menjalankan perintah
    ```
    git clone https://github.com/ameliaanathasa/API-Automation-Test.git
    ```
2. Buka proyek menggunakan IDE pemrograman, disarankan menggunakan IntelliJ
3. Proses instalasi JavaBuild akan dilakukan secara otomatis ketika proyek dibuka dan tunggu hingga proses instalasi selesai.

### Konfigurasi ###
Proses konfigurasi project menggunakan build automation pada file `pom.xml`. Semua dependency yang dibutuhkan ditambahkan di dalam dependencies, seperti: 
1. Dependency untuk melakukan pengujian API menggunakan Rest Assured. 
    ```
     <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.4.0</version>
            <scope>test</scope>
      </dependency>
    ```
2. Dependency untuk menggunakan TestNG sebagai framework pengujian.
   ```
   <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.10.2</version>
        <scope>test</scope>
   </dependency>

   ```
3. Dependency untuk melakukan validasi skema JSON
   ```
   <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>json-schema-validator</artifactId>
        <version>5.3.0</version>
   </dependency>

   ```

### Struktur Project ###
Tujuan proyek ini adalah untuk melakukan pengujian API pada web DummyAPI secara otomatis. Kode program untuk melakukan pengujian tersimpan dalam direktori `test`. Berikut adalah struktur proyek secara keseluruhan.
```
.
└── src
    ├── main
    └── test
        ├── java
        │   ├── APITest.java
        │   └── Main.java
        ├── resources
        │   ├── create-schema.json
        │   ├── schema.json
        │   └── schema_id_only.json
        └── schema.json
```
- `APITest.java` berisi kumpulan script tes otomatis untuk menguji API yang tersedia pada DummyAPI.
- `create-schema.json` skema JSON yang digunakan untuk memvalidasi respons JSON dari permintaan POST.
- `schema.json` skema JSON yang digunakan untuk memvalidasi data yang diterima dalam format JSON.
- `schema_id_only.json` memvalidasi respons JSON yang hanya mengandung properti id.

### How to Run ###
Untuk melakukan eksekusi API testing ini, terdapat dua cara yang dapat dilakukan yaitu menggunakan terminal dan `Class APITest`. 

#### Terminal ####
Untuk melakukan proses eksekusi API testing menggunakan terminal, yaitu: 
1. Pastikan terminal berada dalam direktori `/APIAutomationTest`
2. Ketik perintah berikut dalam terminal untuk menjalankan program:
    ```
    mvn test
    ```

### Class APITest ####
Untuk melakukan proses eksekusi API testing ini cukup dengan melakukan running test dengan menekan icon run pada class APITest yang ada pada IDE. 

### Persiapan Data ###
Sebelum melakukan eksekusi program dan menjalankan test case, data test perlu dipersiapkan terlebih dahulu, seperti: 
1. Pastikan memiliki `app-id` yang didapatkan dari website https://dummyapi.io/account 
2. Pastikan `app-id` yang digunakan valid
2. Pastikan id user yang digunakan valid saat menguji UPDATE

### Fitur Software Under Test ####
Pengujian dilakukan pada program User Controller pada tautan https://dummyapi.io/docs/user untuk pengujian :
- Hit API Update User (PUT)

### Test Case ####
Pada proyek ini dibuat lima buah test script untuk pengujian method PUT dari keseluruhan test case, sehingga terdapat 5 test case yang diuji secara otomatis dalam proyek ini, diantaranya :
1. Pengujian update data user dengan id user valid tetapi tidak ada di sistem
2. Pengujian update data user pada field firstName dengan nilai yang valid
3. Pengujian update data user pada field firstName dengan nilai yang invalid (bukan string)
4. Pengujian update data user pada field firstName dengan jumlah karakter kurang dari 2
5. Pengujian update data user pada field email dengan value kosong (“”)

### Mengakses Test Report ###
Untuk melihat test report hasil pengujian dapat diakses melalui direktori : 
`\test-output\index.html`

### Lingkup ###
Untuk kebutuhan portofolio, maka ditampilkan test script yang dikerjakan oleh Amelia Nathasa saja 

### Referensi ###
- [Maven Documentation](https://maven.apache.org/guides/index.html)
- [TestNg Documentation](https://www.javadoc.io/doc/org.testng/testng/6.8.17/org/testng/Assert.html)
- [Rest Assured Documentation](https://rest-assured.io/)
- [Rest Assured Tutorial](https://www.toolsqa.com/rest-assured-)
- [Rest Assured Video Tutorial](https://www.youtube.com/watch?v=Orn8cP1yRJc)
