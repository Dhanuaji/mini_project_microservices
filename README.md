# mini_project_microservices
Mini project assesment

#### Project ini menggunakan beberapa atau implementasi dari :
#### Spring IoC 
#### Native Query pada repository
#### Java Stream pada service Impl
#### Microservice menggunakan eureka server
#### Database online menggunakan db4free.net

## Dimohon untuk lakukan mvn clean & mvn verify, sebelum dijalankan

## Project ini mengenai simple Restful API untuk sebuah kelas Bimbel dimana setiap murid dapat memilih guru sesuai ketersediaan
## Tersusun dari 3 module
-- Discovery Service
-- Guru Service
-- Siswa Service

## API ##
-- Menggunakan IP address eureka :
http://192.168.137.8:{port}/{endpoint}

-- Menggunakan localhost : http://localhost:/{port}/{endpoint}

### API Guru Service ###
#### (GetMapping) http://192.168.137.8:8082/guru-service/guru : getAll guru
#### (GetMapping) http://192.168.137.8:8082/guru-service/guru/aktif : getAll guru berstatus aktif
#### (GetMapping) http://192.168.137.8:8082/guru-service/guru/tidak-aktif : getAll guru berstatus tidak aktif
#### (GetMapping) http://192.168.137.8:8082/guru-service/guru/{id} : get guru menggunakan ID
#### (GetMapping) http://192.168.137.8:8082/guru-service/guru//get-guru-bertugas/{nikgurubertugas} : get guru dengan status aktif menggunakan nik
#### (PostMapping) http://192.168.137.8:8082/guru-service/guru : menambahkan guru
#### (PutMapping) http://192.168.137.8:8082/guru-service/guru : mengubah nik dan nama lengkap guru berdasarkan ID

### API Siswa Service ###
#### (GetMapping) http://192.168.137.8:8081/siswa-service/siswa : getAll siswa
#### (GetMapping) http://192.168.137.8:8081/siswa-service/siswa/aktif : getAll siswa berstatus aktif
#### (GetMapping) http://192.168.137.8:8081/siswa-service/siswa/tidak-aktif : getAll siswa berstatus tidak aktif
#### (GetMapping) http://192.168.137.8:8081/siswa-service/siswa/{id} : get siswa menggunakan ID
#### (PostMapping) http://192.168.137.8:8082/guru-service/guru : menambahkan siswa dengan mendapatkan value guru yang dipilih berstatus aktif menggunakan nik guru





