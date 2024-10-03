package com.valeriaukat.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.valeriaukat.happybirthday.ui.theme.HappyBirthdayTheme
import androidx.compose.foundation.layout.Box

// Kelas utama yang menjalankan aplikasi
class MainActivity : ComponentActivity() {
    // Metode onCreate dipanggil saat aktivitas dimulai
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Memanggil metode superclass untuk inisialisasi
        setContent { // Menetapkan konten UI untuk aktivitas ini
            HappyBirthdayTheme { // Mengaplikasikan tema untuk aplikasi
                // Menggunakan Surface sebagai kontainer dengan warna latar belakang dari tema
                Surface(
                    modifier = Modifier.fillMaxSize(),// Mengisi seluruh ukuran layar
                    color = MaterialTheme.colorScheme.background // Mengatur warna latar belakang
                ) {
                    // Menampilkan pesan ucapan selamat ulang tahun
                    GreetingImage(
                        message = "Happy Birthday Valeria!", // Pesan ucapan
                        from = "From Elen", // Nama pengirim
                        modifier = Modifier.padding(8.dp) // Menambahkan padding di sekitar teks
                    )
                }
            }
        }
    }
}
// Fungsi Composable untuk menampilkan teks ucapan
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    // Menggunakan Column untuk menata teks secara vertikal
    Column(
        verticalArrangement = Arrangement.Center, // Mengatur isi kolom di tengah secara vertikal
        modifier = modifier // Menggunakan modifier yang diteruskan
    ) {
        // Menampilkan pesan utama
        Text(
            text = message, // Teks ucapan
            fontSize = 100.sp, // Ukuran font
            lineHeight = 116.sp, // Tinggi baris
            textAlign = TextAlign.Center // Menyusun teks di tengah
        )
        // Menampilkan nama pengirim
        Text(
            text = from, // Teks pengirim
            fontSize = 36.sp, // Ukuran font untuk pengirim
            modifier = Modifier
                .padding(16.dp) // Menambahkan padding di sekitar teks pengirim
                .align(alignment = Alignment.End) // Menyusun teks pengirim ke kanan
        )
    }
}

// Fungsi untuk menampilkan pratinjau dari GreetingText dalam IDE
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme { // Mengaplikasikan tema yang sama untuk pratinjau
        GreetingImage(
        // Menampilkan pratinjau dengan pesan dan pengirim yang sama
        message = "Happy Birthday Valeria", from = "From Elen")
    }
}
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.anjing)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}
