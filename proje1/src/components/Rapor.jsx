import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './Style.css';

function App() {
  // Raporları ve seçili raporları tutan state
  const [raporlar, setRaporlar] = useState([]);
  const [selectedRapor, setSelectedRapor] = useState(null);
  const [editingRapor, setEditingRapor] = useState(null);

  // Arama kriterlerini tutan  state
  const [searchCriteria, setSearchCriteria] = useState({
    hastaAd: '',
    hastaSoyad: '',
    hastaTc: '',
    laborantAd: '',
    laborantSoyad: ''
  });

  // Sayfa yüklendiğinde raporları getirecek olan fonksiyon
  useEffect(() => {
    fetchRaporlar();
  }, []);

  // Raporları API'den getirmek için fonks.
  const fetchRaporlar = () => {
    axios.get('http://localhost:8080/api/raporlar/tum')
      .then(response => {
        setRaporlar(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  };

  // Raporları tarihe göre sıralama fonks
  const handleSortByDate = () => {
    const sortedRaporlar = [...raporlar].sort((a, b) => new Date(a.raporunVerildigiTarih) - new Date(b.raporunVerildigiTarih));
    setRaporlar(sortedRaporlar);
  };

  // Tarihi düzenleyen fonks.
  const formatUnixTimestamp = (timestamp) => {
    return new Date(timestamp).toLocaleDateString();
  };

  // Detayları görüntüleyen fonks.
  const handleDetayIncele = (rapor) => {
    setSelectedRapor(rapor);
  };

  // Raporu düzenleyen fonks.
  const handleRaporDuzenle = (rapor) => {
    setEditingRapor(rapor);
  };

  // Input değişikliklerini incelmek için kullanılan fonks.
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setEditingRapor({ ...editingRapor, [name]: value });
  };

  // Raporu güncellemek için fonks.
  const handleRaporGuncelle = () => {
    axios.put(`http://localhost:8080/api/raporlar/guncelle`, editingRapor)
      .then(response => {
        console.log('Rapor başarıyla güncellendi.');
        fetchRaporlar();
        setEditingRapor(null);
      })
      .catch(error => {
        console.error('Error updating rapor:', error);
      });
  };

  // Dosya değişikliğini işlemek için fonks.
  const handleFileChange = (event, raporId) => {
    const file = event.target.files[0];
    uploadFile(file, raporId);
  };

  // Dosyayı yükleme fonks.
  const uploadFile = (file, raporId) => {
    const formData = new FormData();
    formData.append('file', file);

    axios.post(`http://localhost:8080/api/raporlar/foto-yukle?raporId=${raporId}`, formData)
      .then(response => {
        console.log(response.data);
      })
      .catch(error => {
        console.error('Error uploading file:', error);
      });
  };

  // Rapor silme fonks.
  const handleRaporSil = (id) => {
    axios.delete(`http://localhost:8080/api/raporlar/sil/${id}`)
      .then(response => {
        console.log('Rapor başarıyla silindi.');
        fetchRaporlar();
      })
      .catch(error => {
        console.error('Error deleting rapor:', error);
      });
  };

  // Arama kriterlerini güncellemek için fonks.
  const handleChangeSearchCriteria = (e) => {
    const { name, value } = e.target;
    setSearchCriteria({ ...searchCriteria, [name]: value });
  };

  // Arama yapan fonks.
  const handleSearch = () => {
    const filteredCriteria = Object.keys(searchCriteria)
      .filter(key => searchCriteria[key])
      .reduce((obj, key) => {
        obj[key] = searchCriteria[key];
        return obj;
      }, {});

    axios.get('http://localhost:8080/api/raporlar/arama', { params: filteredCriteria })
      .then(response => {
        setRaporlar(response.data);
      })
      .catch(error => {
        console.error('Error searching raporlar:', error);
      });
  };

  // Arama kriterlerini temizleme fonks.
  const handleClearSearch = () => {
    setSearchCriteria({
      hastaAd: '',
      hastaSoyad: '',
      hastaTc: '',
      laborantAd: '',
      laborantSoyad: ''
    });
    fetchRaporlar();
  };

  return (
    <div >
      <h1>Laboratuvar Raporlama</h1>
      <h2>Rapor Arama</h2>
      {/* Yapılan Arama Kriterleri */}

      <div className="aramaKismi"> 
        <label htmlFor="hastaAd">Hasta Adı:</label>
        <input type="text" id="hastaAd" name="hastaAd" value={searchCriteria.hastaAd} onChange={handleChangeSearchCriteria} />
        {' '}  
        <label htmlFor="hastaSoyad">Hasta Soyadı:</label>
        <input type="text" id="hastaSoyad" name="hastaSoyad" value={searchCriteria.hastaSoyad} onChange={handleChangeSearchCriteria} />
        <button onClick={handleSearch}>Ara</button>
        {' '} 
        <button onClick={handleClearSearch}>Temizle</button>
      </div>
      <br />
      <div className="aramaKismi"> 

        <label htmlFor="hastaTc">Hasta TC Numarası:</label>
        <input type="text" id="hastaTc" name="hastaTc" value={searchCriteria.hastaTc} onChange={handleChangeSearchCriteria} />
        <button onClick={handleSearch}>Ara</button>
        {' '}
        <button onClick={handleClearSearch}>Temizle</button>
      </div>
      <br />
      <div className="aramaKismi"> 

        <label htmlFor="laborantAd">Laborant Adı:</label>
        <input type="text" id="laborantAd" name="laborantAd" value={searchCriteria.laborantAd} onChange={handleChangeSearchCriteria} />
        {' '}  
        
        <label htmlFor="laborantSoyad">Laborant Soyadı:</label>
        <input type="text" id="laborantSoyad" name="laborantSoyad" value={searchCriteria.laborantSoyad} onChange={handleChangeSearchCriteria} />
        <button onClick={handleSearch}>Ara</button>
        {' '}    
        <button onClick={handleClearSearch}>Temizle</button>
      </div>
      {/* Genel Raporlar Tablosu */}
     
      <br />
     

      <h2>Raporlar</h2>
      <table>
        <thead>
          <tr>
            <th>Hasta Adı</th>
            <th>Hasta Soyadı</th>
            <th>Hasta TC Numarası</th>
            <th>Koyulan Tanı Başlığı</th>
            <th>Tanı Detayları</th>
            <th>
              <button onClick={handleSortByDate}>Raporun Verildiği Tarihe Göre Sırala</button>
            </th>
            <th>Detay İncele</th>
            <th>Düzenle</th>
            <th>Fotoğraf</th>
            <th>Sil</th>
          </tr>
        </thead>
        <tbody>
          {raporlar.map(rapor => (
            <tr key={rapor.dosyaNumarasi}>
              <td>{rapor.hastaAd}</td>
              <td>{rapor.hastaSoyad}</td>
              <td>{rapor.hastaTcNumarasi}</td>
              <td>{rapor.koyulanTaniBasligi}</td>
              <td>{rapor.taniDetaylari}</td>
              <td>{formatUnixTimestamp(rapor.raporunVerildigiTarih)}</td>
              <td>
                <button onClick={() => handleDetayIncele(rapor)}>Detay İncele</button>
              </td>
              <td>
                <button onClick={() => handleRaporDuzenle(rapor)}>Düzenle</button>
              </td>
              <td>
                <input type="file" onChange={(e) => handleFileChange(e, rapor.dosyaNumarasi)} />
              </td>
              <td>
                <button onClick={() => handleRaporSil(rapor.dosyaNumarasi)}>Sil</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      {/* Rapor Detayları */}
      {selectedRapor && (
        <div className="modal">
          <p>Laborant Adı: {selectedRapor.laborant.ad}</p>
          <p>Laborant Soyadı: {selectedRapor.laborant.soyad}</p>
          <p>Laborant Hastane Kimlik Numarası: {selectedRapor.laborant.hastane_kimlik_numarasi}</p>
          <button onClick={() => setSelectedRapor(null)}>Kapat</button>
        </div>
      )}
      {/* Rapor Düzenleme Kısmı */}
      {editingRapor && (
        <div className="modal">
          <h3>Rapor Düzenle</h3>
          <div className="form-group">
            <label htmlFor="hastaAd">Hasta Adı:</label>
            <input type="text" id="hastaAd" name="hastaAd" value={editingRapor.hastaAd} onChange={handleInputChange} />
          </div>
          <div className="form-group">
            <label htmlFor="hastaSoyad">Hasta Soyadı:</label>
            <input type="text" id="hastaSoyad" name="hastaSoyad" value={editingRapor.hastaSoyad} onChange={handleInputChange} />
          </div>
         
          <div className="form-group">
            <label htmlFor="koyulanTaniBasligi">Koyulan Tanı Başlığı:</label>
            <input type="text" id="koyulanTaniBasligi" name="koyulanTaniBasligi" value={editingRapor.koyulanTaniBasligi} onChange={handleInputChange} />
          </div>
          <button onClick={handleRaporGuncelle}>Kaydet</button>
          <button onClick={() => setEditingRapor(null)}>İptal</button>
        </div>
      )}
    </div>
  );
}

export default App; 