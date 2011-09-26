package com.hospital.activity;
class CityDB {
	private static final String[] CITY=new String[] {"Achalpur (Maharashtra)", "Addanki (Telengana)", "Adilabad (Andhra Pradesh)", "Adipur (Gujarat)", "Adoni (Andhra Pradesh)", "Adoor (Kerala)", "Adra, Purulia (West Bengal)", "Agartala (Tripura)", "Agra (Uttar Pradesh)", "Ahmedabad (Gujarat)", "Ahmedgarh (Punjab)", "Ahmednagar (Maharashtra)", "Aizawl (Mizoram)", "Ajmer (Rajasthan)", "Akaltara (Chhattisgarh)", "Akola (Maharashtra)", "Alappuzha (Kerala)", "Aligarh (Uttar Pradesh)", "Alipurduar (West Bengal)", "Allahabad (Uttar Pradesh)", "Almora (Uttaranchal)", "Alwar (Rajasthan)", "Amadalavalasa (Andhra Pradesh)", "Amalapuram (Andhra Pradesh)", "Amarpur (Bihar)", "Ambikapur (Chhattisgarh)", "Ambala (Haryana)", "Ambala (Haryana)", "Amli (Dadra & Nagar Haveli)", "Amravati (Maharashtra)", "Amreli (Gujarat)", "Amritsar (Punjab)", "Amroha (Uttar Pradesh)", "Anakapalle (Andhra Pradesh)", "Anand (Gujarat)", "Anandapur (Orissa)", "Anantapur (Andhra Pradesh)", "Anantnag (Jammu and Kashmir)", "Ancharakandy (Kerala)", "Ankleshwar (Gujarat)", "Anugul (Orissa)", "Arakkonam (Tamil Nadu)", "Araria (Bihar)", "Arambagh (West Bengal)", "Arasikere (Karnataka)", "Arcot (Tamil Nadu)", "Areraj (Bihar)", "Arrah (Bihar)", "Aroor (Kerala)", "Aruppukkottai (Tamil Nadu)", "Asansol (West Bengal)", "Ashok Nagar (Madhya Pradesh)", "Ashtamichira (Kerala)", "Asika (Orissa)", "Assandh (Haryana)", "Attingal (Kerala)", "Aurangabad (Bihar)", "Aurangabad (Maharashtra)", "Azamgarh (Uttar Pradesh)", "Bangalore (Karnataka)", "Babiyal (Haryana)", "Baddi (Himachal Pradesh)", "Bade Bacheli (Chhattisgarh)", "Badepalle (Andhra Pradesh)", "Badharghat (Tripura)", "Bagaha (Bihar)", "Bahadurgarh (Haryana)", "Bahadurganj (Bihar)", "Baharampur (West Bengal)", "Bahraich (Uttar Pradesh)", "Bairgania (Bihar)", "Bakhtiarpur (Bihar)", "Balaghat (Madhya Pradesh)", "Balangir (Orissa)", "Balasore (Orissa)", "Baleshwar (Orissa)", "Bali (Rajastan)", "Bally (West Bengal)", "Ballabhgarh (Hariyana)", "Ballia (Uttar Pradesh)", "Balod (Chhattisgarh)", "Baloda Bazar (Chhattisgarh)", "Balrampur (Uttar Pradesh)", "Balurghat (West Bengal)", "Banda (Uttar Pradesh)", "Bandipore (Jammu and Kashmir)", "Banganapalle (Andhra Pradesh)", "Banka (Bihar)", "Banmankhi Bazar (Bihar)", "Banswara (Rajastan)", "Bankura (West Bengal)", "Bapatla (Andhra Pradesh)", "Barahiya (Bihar)", "Baramula (Jammu and Kashmir)", "Barasat (West Bengal)", "Bardhaman (West Bengal)", "Barakar (West Bengal)", "Barauli (Bihar)", "Barbigha (Bihar)", "Bareilly (Uttar Pradesh)", "Bargarh (Odisha)", "Barughutu (Jharkhand)", "Bandikui (Rajasthan)", "Barbil (Orissa)", "Bargarh (Orissa)", "Barh (Bihar)", "Baripada (Orissa)", "Barmer (Rajasthan)", "Barnala (Punjab)", "Barpeta (Assam)", "Barpeta Road (Assam)", "Barwala (Haryana)", "Basudebpur (Orissa)", "Batala (Punjab)", "Bathinda (Punjab)", "Bazpur (Uttaranchal)", "Begusarai (Bihar)", "Behea (Bihar)", "Belgaum (Karnataka)", "Bellampalle (Andhra Pradesh)", "Bellary (Karnataka)", "Belpahar (Orissa)", "Bemetra (Chhattisgarh)", "Bangalore (Karnataka)", "Bethamcherla (Andhra Pradesh)", "Bettiah (Bihar)", "Betul (Madhya Pradesh)", "Bhabua (Bihar)", "Bhadrachalam (Andhra Pradesh)", "Bhadrak (Orissa)", "Bhagalpur (Bihar)", "Bhagha Purana (Punjab)", "Bhainsa (Andhra Pradesh)", "Bharuch (Gujarat)", "Bhatapara (Chhattisgarh)", "Bhavani (Tamil Nadu)", "Bhavnagar (Gujarat)", "Bhawanipatna (Orissa)", "Bheemunipatnam (Andhra Pradesh)", "Bhimavaram (Andhra Pradesh)", "Bhiwani (Haryana)", "Bhongir (Andhra Pradesh)", "Bhopal (Madhya Pradesh)", "Bhuban (Orissa)", "Bhubaneswar (Orissa)", "Bhuj (Gujarat)", "Bidhan Nagar (West Bengal)", "Bihar (Bihar)", "Bikaner (Rajasthan)", "Bikramganj (Bihar)", "Bilasipara (Assam)", "Bilaspur (Chhattisgarh)", "Bilaspur (Himachal Pradesh)", "Biramitrapur (Orissa)", "Birgaon (Chhattisgarh)", "Bobbili (Andhra Pradesh)", "Bodhan (Andhra Pradesh)", "Bodh Gaya (Bihar)", "Bokaro Steel City (Jharkhand)", "Bongaigaon (Assam)", "Bomdila (Arunachal Pradesh)", "Brahmapur (Orissa)", "Brajrajnagar (Orissa)", "Budaun (Uttar Pradesh)", "Budhlada (Punjab)", "Burhanpur (Madhya Pradesh)", "Buxar (Bihar)", "Byasanagar (Orissa)", "Calcutta (West Bengal)", "Cambay (Gujarat)", "Chaibasa (Jharkhand)", "Chakeri (Uttar Pradesh)", "Chakradharpur (Jharkhand)", "Chalisgaon (Maharashtra)", "Chamba (Himachal Pradesh)", "Chamba (Uttarakhand)", "Champa (Chhattisgarh)", "Champawat (Chhattisgarh)", "Champhai (Mizoram)", "Chamrajnagar (Karnataka)", "Chandannagar (West Bengal)", "Chandigarh (Punjab)", "Chandil (Chhattisgarh)", "Chandausi (Uttar Pradesh)", "Chandrapura (Jharkhand)", "Chanpatia (Bihar)", "Charkhi Dadri (Haryana)", "Chatra (Jharkhand)", "Chalakudy (Kerala)", "Changanassery (Kerala)", "Cheeka (Haryana)", "Chendamangalam (Kerala)", "Chengalpattu (Tamil Nadu)", "Chengannur (Kerala)", "Chennai (Tamil Nadu)", "Cherthala (Kerala)", "Cheruthazham (Kerala)", "Chhapra (Bihar)", "Chhatarpur (Orissa)", "Chilakaluripet (Andhra Pradesh)", "Chintamani (Karnataka)", "Chirala (Andhra Pradesh)", "Chirkunda (Jharkhand)", "Chirmiri (Chhattisgarh)", "Chinsura (West Bengal)", "Chitradurga (Karnataka)", "Chittur-Thathamangalam (Kerala)", "Chittoor (Andhra Pradesh)", "Chockli (Kerala)", "Churi (Jharkhand)", "Coimbatore (Tamil Nadu)", "Colgong (Bihar)", "Contai (West Bengal)", "Cooch Behar (West Bengal)", "Coonoor (Tamil Nadu)", "Cuddalore (Tamil Nadu)", "Cuddapah (Andhra Pradesh)", "Curchorem Cacora (Goa)", "Cuttack (Orissa)", "Dabra (Madhya Pradesh)", "Dahod (Gujarat)", "Dalhousie (Himachal Pradesh)", "Dalli-Rajhara (Chhattisgarh)", "Dalsinghsarai (Bihar)", "Daltonganj (Jharkhand)", "Daman (Daman & Diu)", "Darbhanga (Bihar)", "Darjeeling (West Bengal)", "Dasua (Punjab)", "Datia (Madhya Pradesh)", "Daudnagar (Bihar)", "Debagarh (Orissa)", "Deesa (Gujarat)", "Dehradun (Uttaranchal)", "Dehri-on-Sone (Bihar)", "Delhi (Delhi)", "Deoghar (Jharkhand)", "Devarakonda (Andhra Pradesh)", "Devgarh (Maharashtra)", "Dewas (Madhya Pradesh)", "Dhaka (Bihar)", "Dhamtari (Chhattisgarh)", "Dhanbad (Jharkhand)", "Dhar (Madhya Pradesh)", "Dharampur (Gujarat)", "Dharamsala (Himachal Pradesh)", "Dharmanagar (Tripura)", "Dharmavaram (Andhra Pradesh)", "Dhekiajuli (Assam)", "Dhenkanal (Orissa)", "Dholka (Gujarat)", "Dhubri (Assam)", "Dhuri (Punjab)", "Dibrugarh (Assam)", "Digboi (Assam)", "Dighwara (Bihar)", "Dimapur (Nagaland)", "Dinanagar (Punjab)", "Dindigul (Tamil Nadu)", "Diphu (Assam)", "Dipka (Chhattisgarh)", "Dispur (Assam)", "Diu (Daman & Diu)", "Dombivli (Maharashtra)", "Dongargarh (Chhattisgarh)", "Duliajan Oil Town (Assam)", "Dumka (Jharkhand)", "Dumraon (Bihar)", "Durg-Bhilai Nagar (Chhattisgarh)", "Durgapur (Maharashtra)", "Durgapur (West Bengal)", "Ellenabad (Haryana)", "Eluru (Andhra Pradesh)", "Erattupetta (Kerala)", "Etawah (Uttar Pradesh)", "Faridabad (Haryana)", "Faridkot (Punjab)", "Farooqnagar (Andhra Pradesh)", "Fatehabad (Haryana)", "Fatehabad (Madhya Pradesh)", "Fatehabad (Uttar Pradesh)", "Fatehgarh (Uttar Pradesh)", "Fatehpur Chaurasi (Uttar Pradesh)", "Fatehpur Sikri (Uttar Pradesh)", "Fatehpur (Rajasthan)", "Fatehpur (Uttar Pradesh)", "Fatehpur (Uttar Pradesh)", "Fatwah (Bihar)", "Fazilka (Punjab)", "Forbesganj (Bihar)", "Firozabad (Bihar)", "Firozpur (Punjab)", "Firozpur Cantt. (Punjab)", "Gadag (Punjab)", "Gadchiroli (Punjab)", "Gadwal (Andhra Pradesh)", "Ganaur (Haryana)", "Gandhidham (Haryana)", "Gandhinagar (Gujarat)", "Gangtok (Sikkim)", "Garhwa (Jharkhand)", "Gauripur (Assam)", "Gaya (Bihar)", "Gharaunda (Bihar)", "Ghatampur (Bihar)", "Ghatanji (Bihar)", "Ghatshila (Jharkhand)", "Ghaziabad (Bihar)", "Ghazipur (Bihar)", "Giddarbaha (Punjab)", "Giridih (Jharkhand)", "Goa Velha (Goa)", "Goalpara (Assam)", "Gobindgarh (Punjab)", "Gobranawapara (Chhattisgarh)", "Godda (Jharkhand)", "Godhra (Gujarat)", "Gogri Jamalpur (Bihar)", "Gohana (Haryana)", "Golaghat (Assam)", "Gomoh (Jharkhand)", "Gooty (Andhra Pradesh)", "Gopalganj (Bihar)", "Gorakhpur (Uttar Pradesh)", "Greater Noida (Uttar Pradesh)", "Gudalur (Tamil Nadu)", "Gudalur (Tamil Nadu)", "Gudalur (Tamil Nadu)", "Gudivada (Andhra Pradesh)", "Gudur (Andhra Pradesh)", "Gulbarga (Karnataka)", "Gumia (Jharkhand)", "Gumla (Jharkhand)", "Gundlupet (Karnataka)", "Guntakal (Andhra Pradesh)", "Guntur (Andhra Pradesh)", "Gunupur (Orissa)", "Gurdaspur (Punjab)", "Gurgaon (Haryana)", "Guruvayoor (Kerala)", "Guwahati (Assam)", "Gwalior (Madhya Pradesh)", "Haflong (Assam)", "Hailakandi (Assam)", "Hajipur (Bihar)", "Haldia (West Bengal)", "Haldwani (Uttaranchal)", "Hamirpur (Himachal Pradesh)", "Hamirpur (Uttar Pradesh)", "Hansi (Haryana)", "Hanuman Junction (Andhra Pradesh)", "Hardoi (Uttar Pradesh)", "Haridwar (Uttaranchal)", "Hassan (Karnataka)", "Hazaribag (Jharkhand)", "Hilsa (Bihar)", "Himatnagar (Gujarat)", "Hindupur (Andhra Pradesh)", "Hinjilicut (Orissa)", "Hisar (Haryana)", "Hisua (Bihar)", "Hodal (Haryana)", "Hojai (Assam)", "Hoshiarpur (Punjab)", "Hospet (Karnataka)", "Howrah (West Bengal)", "Hubli (Karnataka)", "Hussainabad (Jharkhand)", "Hyderabad (Andhra Pradesh)", "Ichalkaranji (Maharashtra)", "Ichchapuram (Andhra Pradesh)", "Idar (Gujarat)", "Imphal (Manipur)", "Indore (Madhya Pradesh)", "Indranagar (Tripura)", "Irinjalakuda (Kerala)", "Islampur (Bihar)", "Islampur (West Bengal)", "Itanagar (Arunachal Pradesh)", "Itarsi (Madhya Pradesh)", "Jabalpur (Madhya Pradesh)", "Jagatsinghapur (Orissa)", "Jagdalpur (Chhattisgarh)", "Jagdishpur (Bihar)", "Jaggaiahpet (Andhra Pradesh)", "Jagraon (Punjab)", "Jagtial (Andhra Pradesh)", "Jaipur (Rajasthan)", "Jaisalmer (Rajasthan)", "Jaitu (Punjab)", "Jajapur (Orissa)", "Jalalabad (Punjab)", "Jalna (Maharashtra)", "Jalandhar Cantt. (Punjab)", "Jalandhar (Punjab)", "Jaleswar (Orissa)", "Jamalpur (Bihar)", "Jammalamadugu (Andhra Pradesh)", "Jammu (Jammu & Kashmir)", "Jamnagar (Gujarat)", "Jamshedpur (Jharkhand)", "Jamtara (Jharkhand)", "Jamui (Bihar)", "Jandiala (Punjab)", "Jangaon (Andhra Pradesh)", "Jashpurnagar (Chhattisgarh)", "Jaspur (Uttaranchal)", "Jatani (Orissa)", "Jaunpur (Uttar Pradesh)", "Jehanabad (Bihar)", "Jeypur (Orissa)", "Jhajha (Bihar)", "Jhajjar (Haryana)", "Jhanjharpur (Bihar)", "Jhansi (Uttar Pradesh)", "Jharsuguda (Orissa)", "Jhumri Tilaiya (Jharkhand)", "Jind (Haryana)", "Joda (Orissa)", "Jodhpur (Rajasthan)", "Jogabani (Bihar)", "Jogendranagar (Tripura)", "Jorhat (Assam)", "Jowai (Meghalaya)", "Junagadh (Gujarat)", "Kadapa (Andhra Pradesh)", "Kadi (Gujarat)", "Kadiri (Andhra Pradesh)", "Kadirur (Kerala)", "Kagaznagar (Andhra Pradesh)", "Kailasahar (Tripura)", "Kaithal (Haryana)", "Kakching (Manipur)", "Kakinada (Andhra Pradesh)", "Kalan Wali (Haryana)", "Kalavad (Gujarat)", "Kalka (Haryana)", "Kalliasseri (Kerala)", "Kalol (Gujarat)", "Kalol (Gujarat)", "Kalpetta (Kerala)", "Kalyandurg (Andhra Pradesh)", "Kamareddy (Andhra Pradesh)", "Kanchipuram (Tamil Nadu)", "Kandukur (Andhra Pradesh)", "Kanhangad (Kerala)", "Kanjikkuzhi (Kerala)", "Kanker (Chhattisgarh)", "Kannur (Kerala)", "Kantabanji (Orissa)", "Kanti (Bihar)", "Kapadvanj (Gujarat)", "Kapurthala (Punjab)", "Karaikal (Pondicherry)", "Karaikudi (Tamil Nadu)", "Karanjia (Orissa)", "Karimganj (Assam)", "Karimnagar (Andhra Pradesh)", "Karjan (Gujarat)", "Karkala (Karnataka)", "Karnal (Haryana)", "Karoran (Punjab)", "Kartarpur (Punjab)", "Karur (Tamil Nadu)", "Karungal (Tamil Nadu)", "Karwar (Karnataka)", "Kasaragod (Kerala)", "Kashipur (Uttaranchal)", "Kathua (Jammu and Kashmir)", "Katihar (Bihar)", "Katni (Madhya Pradesh)", "Kavali (Andhra Pradesh)", "Kavaratti (Lakshadweep)", "Kawardha (Chhattisgarh)", "Kayamkulam (Kerala)", "Kendrapara (Orissa)", "Kendujhar (Orissa)", "Keshod (Gujarat)", "Khagaria (Bihar)", "Khambhalia (Gujarat)", "Khambhat (Gujarat)", "Khammam (Andhra Pradesh)", "Khanna (Punjab)", "Kharagpur (Bihar)", "Kharagpur (West Bengal)", "Kharar (Punjab)", "Kheda (Gujarat)", "Khedbrahma (Gujarat)", "Kheralu (Gujarat)", "Khordha (Orissa)", "Khowai (Tripura)", "Khunti (Jharkhand)", "kichha (Uttaranchal)", "Kishanganj (Bihar)", "Kochi (Kerala)", "Kodinar (Gujarat)", "Kodungallur (Kerala)", "Kohima (Nagaland)", "Kokrajhar (Assam)", "Kolar (Karnataka)", "Kolkata (West Bengal)", "Kollam (Kerala)", "Kondagaon (Chhattisgarh)", "Koothuparamba (Kerala)", "Koraput (Orissa)", "Korba (Chhattisgarh)", "Koratla (Andhra Pradesh)", "Kot Kapura (Punjab)", "Kota (Karnataka)", "Kota (Rajasthan)", "Kota (Uttar Pradesh)", "Kotdwara (Uttaranchal)", "Kothagudem (Andhra Pradesh)", "Kothamangalam (Kerala)", "Kothapeta (Andhra Pradesh)", "Kotma (Madhya Pradesh)", "Kottayam (Kerala)", "Kovvur (Andhra Pradesh)", "Kozhikode (Kerala)", "Kunnamkulam (Kerala)", "Kurali (Punjab)", "Kurnool (Andhra Pradesh)", "Kyathampalle (Andhra Pradesh)", "Lachhmangarh (Rajasthan)", "Ladnu (Rajasthan)", "Ladwa (Haryana)", "Lahar (Madhya Pradesh)", "Laharpur (Uttar Pradesh)", "Lakheri (Rajasthan)", "Lakhimpur (Uttar Pradesh)", "Lakhisarai (Bihar)", "Lakshmeshwar (Karnataka)", "Lal Gopalganj Nindaura (Uttar Pradesh)", "Lalganj (Bihar)", "Lalgudi (Tamil Nadu)", "Lalitpur (Uttar Pradesh)", "Lalganj (Uttar Pradesh)", "Lalsot (Rajasthan)", "Lanka (Assam)", "Lar (Uttar Pradesh)", "Lathi (Gujarat)", "Latur (Maharashtra)", "Leh (Jammu and Kashmir)", "Lilong (Manipur)", "Limbdi (Gujarat)", "Lingsugur (Karnataka)", "Loha (Maharashtra)", "Lohardaga (Jharkhand)", "Lonar (Maharashtra)", "Lonavla (Maharashtra)", "Longowal (Punjab)", "Loni (Uttar Pradesh)", "Losal (Rajasthan)", "Lucknow (Uttar Pradesh)", "Ludhiana (Punjab)", "Lumding (Assam)", "Lunawada (Gujarat)", "Lundi (Madhya Pradesh)", "Lunglei (Mizoram)", "Macherla (Andhra Pradesh)", "Machilipatnam (Andhra Pradesh)", "Madanapalle (Andhra Pradesh)", "Madhepura (Bihar)", "Madgaon (Goa)", "Madhubani (Bihar)", "Madhupur (Jharkhand)", "Madikeri (Karnataka)", "Madurai (Tamil Nadu)", "Mahbubnagar (Andhra Pradesh)", "Maharajganj (Bihar)", "Mahasamund (Chhattisgarh)", "Mahe (Pondicherry)", "Mahendragarh (Chhattisgarh)", "Mahendragarh (Haryana)", "Mahesana (Gujarat)", "Mahnar Bazar (Bihar)", "Mahuva (Gujarat)", "Makhdumpur (Bihar)", "Malappuram (Kerala)", "Malegaon (Maharashtra)", "Malerkotla (Punjab)", "Malkangiri (Orissa)", "Malout (Punjab)", "Manavadar (Gujarat)", "Manchar (Maharashtra)", "Mancherial (Andhra Pradesh)", "Mandamarri (Andhra Pradesh)", "Mandapeta (Andhra Pradesh)", "Mandi (Himachal Pradesh)", "Mandi Dabwali (Haryana)", "Mandvi (Gujarat)", "Mandya (Karnataka)", "Maner (Bihar)", "Mangaldoi (Assam)", "Mangalore (Karnataka)", "Manglaur (Uttaranchal)", "Mangrol (Gujarat)", "Manihari (Bihar)", "Mankachar (Assam)", "Mansa (Punjab)", "Mansa (Gujarat)", "Manuguru (Andhra Pradesh)", "Mapusa (Goa)", "Margherita (Assam)", "Margao (Goa)", "Marhaura (Bihar)", "Mariani (Assam)", "Marigaon (Assam)", "Markapur (Andhra Pradesh)", "Marmagao (Goa)", "Masaurhi (Bihar)", "Mathura (Uttar Pradesh)", "Mattannur (Kerala)", "Maur (Punjab)", "Mavelikkara (Kerala)", "Mavoor (Kerala)", "Mayang Imphal (Manipur)", "Medak (Andhra Pradesh)", "Meerut (Uttar Pradesh)", "Mehmedabad (Gujarat)", "Mihijam (Jharkhand)", "Miraj (Maharashtra)", "Mirganj (Bihar)", "Miryalaguda (Andhra Pradesh)", "Modasa (Gujarat)", "Moga (Punjab)", "Mogalthur (Andhra Pradesh)", "Mohali (Punjab)", "Mokameh (Bihar)", "Mokokchung (Nagaland)", "Morinda (Punjab)", "Morvi (Gujarat)", "Motihari (Bihar)", "Motipur (Bihar)", "Mukerian (Punjab)", "Muktsar (Punjab)", "Mungeli (Chhattisgarh)", "Munger (Bihar)", "Mumbai (Maharashtra)", "Muradnagar (Uttar Pradesh)", "Murliganj (Bihar)", "Murshidabad (West Bengal)", "Musabani (Jharkhand)", "Mussoorie (Uttaranchal)", "Muvattupuzha (Kerala)", "Muzaffarnagar (Uttarpradesh)", "Muzaffarpur (Bihar)", "Mysore (Karnataka)", "Nabarangapur (Orissa)", "Nabha (Punjab)", "Nadiad (Gujarat)", "Nagaon (Assam)", "Nagari (Andhra Pradesh)", "Nagapattinam (Tamil Nadu)", "Nagarkurnool (Andhra Pradesh)", "Nagercoil (Tamil Nadu)", "Nagla (Uttaranchal)", "Nagpur (Maharashtra)", "Nahan (Himachal Pradesh)", "Naharlagun (Arunachal Pradesh)", "Naihati (West Bengal)", "Naila Janjgir (Chhattisgarh)", "Nainital (Uttaranchal)", "Nakodar (Punjab)", "Nalbari (Assam)", "Nandyal (Andhra Pradesh)", "Namakkal (Tamil Nadu)", "Nandyal (Andhra Pradesh)", "Nangal (Punjab)", "Nanjangud (Karnataka)", "Narasapur (Andhra Pradesh)", "Narasaraopet (Andhra Pradesh)", "Narayanpet (Andhra Pradesh)", "Narkatiaganj (Bihar)", "Narnaul (Haryana)", "Narsinghgarh (Damoh) (Madhya Pradesh)", "Narsinghgarh (Rajgarh) (Madhya Pradesh)", "Narsipatnam (Andhra Pradesh)", "Narwana (Haryana)", "Nashik (Maharashtra)", "Naugachhia (Bihar)", "Navi Mumbai (Maharashtra)", "Navsari (Gujarat)", "Nawada (Bihar)", "Nawalgarh (Rajasthan)", "Nawanshahr (Punjab)", "Nedumangad (Kerala)", "Nellore (Andhra Pradesh)", "NOIDA (Uttar Pradesh)", "Neyyattinkara (Kerala)", "Nidadavole (Andhra Pradesh)", "Nirmal (Andhra Pradesh)", "Nizamabad (Andhra Pradesh)", "Nizamabad (Uttar Pradesh)", "Nokha (Bihar)", "Nongstoin (Meghalaya)", "North Lakhimpur (Assam)", "Nuzvid (Andhra Pradesh)", "O' Valley (Tamil Nadu)", "Oddanchatram (Tamil Nadu)", "Obra (Uttar Pradesh)", "Ongole (Andhra Pradesh)", "Orai (Uttar Pradesh)", "Osmanabad (Maharashtra)", "Ottappalam (Kerala)", "Ozar (Maharashtra)", "Padra (Gujarat)", "Pakaur (Jharkhand)", "Palacole (Andhra Pradesh)", "Palai (Kerala)", "Palakkad (Kerala)", "Palanpur (Gujarat)", "Palasa Kasibugga (Andhra Pradesh)", "Palitana (Gujarat)", "Palwal (Haryana)", "Palwancha (Andhra Pradesh)", "Panaji (Goa)", "Panchkula (Haryana)", "Panipat (Haryana)", "Panniyannur (Kerala)", "Panvel (Maharashtra)", "Pappinisseri (Kerala)", "Paradip (Orissa)", "Paravoor (Kerala)", "Pardi (Gujarat)", "Parlakhemundi (Orissa)", "Parvathipuram (Andhra Pradesh)", "Pasighat (Arunachal Pradesh)", "Patan (Gujarat)", "Pathanamthitta (Kerala)", "Pathankot (Punjab)", "Patiala (Punjab)", "Petlad (Gujarat)", "Patna (Bihar)", "Patran (Punjab)", "Patratu (Jharkhand)", "Pattamundai (Orissa)", "Patti (Punjab)", "Pauri (Uttaranchal)", "Payyannur (Kerala)", "Pedana (Andhra Pradesh)", "Peddapuram (Andhra Pradesh)", "Pehowa (Haryana)", "Peringathur (Kerala)", "Perinthalmanna (Kerala)", "Perumbavoor (Kerala)", "Phagwara (Punjab)", "Phillaur (Punjab)", "Phulabani (Orissa)", "Phusro (Jharkhand)", "Pilani (Rajasthan)", "Pimpri Chinchwad (Maharashtra)", "Pinjore (Haryana)", "Piro (Bihar)", "Pithapuram (Andhra Pradesh)", "Pithoragarh (Uttaranchal)", "Pokaran (Rajasthan)", "Pollachi (Tamil Nadu)", "Pondicherry (Pondicherry)", "Ponnani (Kerala)", "Ponnur (Andhra Pradesh)", "Porbandar (Gujarat)", "Port Blair (Andaman and Nicobar Islands)", "Prantij (Rajasthan)", "Pratapgarh (Rajasthan)", "Pratapgarh (Tripura)", "Pratapgarh (Uttar Pradesh)", "Proddatur (Andhra Pradesh)", "Pudukkottai (Tamil Nadu)", "Punalur (Kerala)", "Punch (Jammu and Kashmir)", "Pune (Maharashtra)", "Punganur (Andhra Pradesh)", "Puri (Orissa)", "Purnia (Bihar)", "Purulia (West Bengal)", "Pushkar (Rajasthan)", "Puttur (Andhra Pradesh)", "Qadian (Punjab)", "Quilandy (Kerala)", "Radhanpur (Gujarat)", "Rae Bareli (Uttar Pradesh)", "Rafiganj (Bihar)", "Raigarh (Chhattisgarh)", "Raikot (Punjab)", "Raipur (Chhattisgarh)", "Rairangpur (Orissa)", "Rajagangapur (Orissa)", "Rajahmundry (Andhra Pradesh)", "Rajam (Andhra Pradesh)", "Rajapalayam (Tamil Nadu)", "Rajauri (Jammu and Kashmir)", "Rajgarh (Alwar) (Rajasthan)", "Rajgarh (Churu (Rajasthan)", "Rajgarh (Dhar) (Madhya Pradesh)", "Rajgarh (Rajgarh) (Madhya Pradesh)", "Rajgarh (Himachal Pradesh)", "Rajgir (Bihar)", "Rajgurunagar (Maharashtra)", "Rajkot (Gujarat)", "Rajnandgaon (Chhattisgarh)", "Rajpipla (Gujarat)", "Rajpura (Punjab)", "Rajula (Gujarat)", "Ramachandrapuram (Andhra Pradesh)", "Ramagundam (Andhra Pradesh)", "Ramanagara (Karnataka)", "Ramanathapuram (Tamil Nadu)", "Rameshwaram (Tamil Nadu)", "Ramagarh (Rajasthan)", "Ramngarh (Jharkhand)", "Ramnagar (Asansol) (West Bengal)", "Ramnagar (Durgapur) (West Bengal)", "Ramnagar (Purba Medinipur) (West Bengal)", "Ramnagar (Uttar Pradesh)", "Ramnagar (Bihar)", "Ramnagar (Madhya Pradesh)", "Ramnagar (Uttar Pradesh)", "Ramnagar (Uttaranchal)", "Rampur (Uttar Pradesh)", "Rampura Phul (Punjab)", "Ranavav (Gujarat)", "Ranchi (Jharkhand)", "Rangia (Assam)", "Rani (Rajasthan)", "Rania (Haryana)", "Rapar (Gujarat)", "Ratangarh (Madhya Pradesh)", "Ratangarh (Rajasthan)", "Ratia (Haryana)", "Raurkela (Orissa)", "Raxaul Bazar (Bihar)", "Rayachoti (Andhra Pradesh)", "Rayadurg (Andhra Pradesh)", "Rayagada (Orissa)", "Renigunta (Andhra Pradesh)", "Repalle (Andhra Pradesh)", "Revelganj (Bihar)", "Rewari (Haryana)", "Rishikesh (Uttaranchal)", "Rohtak (Haryana)", "Roorkee (Uttaranchal)", "Rosera (Bihar)", "Rudrapur (Uttaranchal)", "Rupnagar (Punjab)", "Sadalgi (Karnataka)", "Sadasivpet (Andhra Pradesh)", "Sadri (Rajasthan)", "Sadulshahar (Rajasthan)", "Safidon (Haryana)", "Sagar (Madhya Pradesh)", "Sagara (Karnataka)", "Sagwara (Rajasthan)", "Saharsa (Bihar)", "Sahibganj (Jharkhand)", "Sailu (Maharashtra)", "Sainthia (West Bengal)", "Sakleshpur (Karnataka)", "Sakti (Chhattisgarh)", "Salaya (Gujarat)", "Salem (Tamil Nadu)", "Salur (Andhra Pradesh)", "Samastipur (Bihar)", "Samalkha (Haryana)", "Samalkot (Andhra Pradesh)", "Samana (Punjab)", "Sambalpur (Orissa)", "Sambhar (Rajasthan)", "Sanand (Gujarat)", "Sanchore (Rajasthan)", "Sandur (Karnataka)", "Sankeshwar (Karnataka)", "Sangamner (Maharashtra)", "Sangareddy (Andhra Pradesh)", "Sangaria (Rajasthan)", "Sangli (Maharashtra)", "Sangole (Maharashtra)", "Sangrur (Punjab)", "Santipur (West Bengal)", "Sardarshahar (Rajasthan)", "Sasaram (Bihar)", "Sasvad (Maharashtra)", "Sathyamangalam (Tamil Nadu)", "Satana (Maharashtra)", "Satara (Maharashtra)", "Satna (Madhya Pradesh)", "Sattenapalle (Andhra Pradesh)", "Saunda (Jharkhand)", "Saundatti-Yellamma (Karnataka)", "Savarkundla (Gujarat)", "Savner (Maharashtra)", "Savanur (Karnataka)", "Sawai Madhopur (Rajasthan)", "Sawantwadi (Maharashtra)", "Secundrabad (Andhra Pradesh)", "Sedam (Karnataka)", "Shahade (Maharashtra)", "Shahabad (Karnataka)", "Shahbad (Haryana)", "Shahpur (Karnataka)", "Shegaon (Maharashtra)", "Shendurjana (Maharashtra)", "Shiggaon (Karnataka)", "Shikapur (Karnataka)", "Shillong (Meghalaya)", "Shimla (Himachal Pradesh)", "Shimoga (Karnataka)", "Shirdi (Maharashtra)", "Shirpur-Warwade (Maharashtra)", "Shirur (Maharashtra)", "Sibsagar (Assam)", "Silapathar (Assam)", "Silchar (Assam)", "Shahpura (Rajasthan)", "Shahpura (Rajasthan)", "Sheikhpura (Bihar)", "Sheoganj (Rajasthan)", "Sheohar (Bihar)", "Sherghati (Bihar)", "Shimoga (Karnataka)", "Shoranur (Kerala)", "Shorapur (Karnataka)", "Shrigonda (Maharashtra)", "Shrirampur (Maharashtra)", "Shrirangapattana (Karnataka)", "Sibsagar (Assam)", "Siddipet (Andhra Pradesh)", "Sidhpur (Gujarat)", "Sidlaghatta (Karnataka)", "Sihor (Gujarat)", "Sikar (Rajasthan)", "Silao (Bihar)", "Siliguri (West Bengal)", "Sillod (Maharashtra)", "Silvassa (Dadra and Nagar Haveli)", "Simdega (Jharkhand)", "Sindgi (Karnataka)", "Sindhnur (Karnataka)", "Singapur (Andhra Pradesh)", "Sinnar (Maharashtra)", "Sira (Karnataka)", "Sircilla (Andhra Pradesh)", "Sirhind Fatehgarh Sahib (Punjab)", "Sirohi (Rajasthan)", "Sirsa (Haryana)", "Sirsa (Uttar Pradesh)", "Sirsi (Karnataka)", "Siruguppa (Karnataka)", "Sitamarhi (Bihar)", "Sitarganj (Uttaranchal)", "Sivakasi (Tamil Nadu)", "Siwan (Bihar)", "Sohna (Haryana)", "Sojat (Rajasthan)", "Solan (Himachal Pradesh)", "Solapur (Maharashtra)", "Sonamukhi (West Bengal)", "Sonepur (Bihar)", "Songadh (Gujarat)", "Sonipat (Haryana)", "Sopore (Jammu and Kashmir)", "Soro (Orissa)", "Soyagaon (Maharashtra)", "Sriganganagar (Rajasthan)", "Srikakulam (Andhra Pradesh)", "Srikalahasti (Andhra Pradesh)", "Sri Madhopur (Rajasthan)", "Srinagar (Jammu and Kashmir)", "Srinivaspur (Karnataka)", "Srisailam Project (RFC) Township (Andhra Pradesh)", "Sugauli (Bihar)", "Sujanpur (Punjab)", "Sujangarh (Rajasthan)", "Sultanganj (Bihar)", "Sumerpur (Rajasthan)", "Sunabeda (Orissa)", "Sunam (Punjab)", "Sundargarh (Orissa)", "Sundarnagar (Himachal Pradesh)", "Supaul (Bihar)", "Surat (Gujarat)", "Suratgarh (Rajasthan)", "Surendranagar (Gujarat)", "Suri (West Bengal)", "Suryapet (Andhra Pradesh)", "Tadepalligudem (Andhra Pradesh)", "Tadpatri (Andhra Pradesh)", "Taki (West Bengal)", "Talaja (Gujarat)", "Talcher (Orissa)", "Talegaon Dabhade (Maharashtra)", "Talikota (Karnataka)", "Taliparamba (Kerala)", "Talode (Maharashtra)", "Talwara (Punjab)", "Tamluk (West Bengal)", "Tanda (Uttar Pradesh)", "Tanda (Uttar Pradesh)", "Tandur (Andhra Pradesh)", "Tanuku (Andhra Pradesh)", "Tarakeswar (West Bengal)", "Taraori (Haryana)", "Tarana (Madhya Pradesh)", "Taranagar (Rajasthan)", "Tarikere (Karnataka)", "Tarn Taran (Punjab)", "Tasgaon (Maharashtra)", "Tehri (Uttaranchal)", "Tekkalakota (Karnataka)", "Tenali (Andhra Pradesh)", "Tenkasi (Tamil Nadu)", "Tenu Dam-cum- Kathhara (Jharkhand)", "Terdal (Karnataka)", "Tetri Bazar (Uttar Pradesh)", "Tezpur (Assam)", "Thakurdwara (Uttar Pradesh)", "Thammampatti (Tamil Nadu)", "Thana Bhawan (Uttar Pradesh)", "Thanesar (Haryana)", "Thangadh (Gujarat)", "Thanjavur (Tamil Nadu)", "Tharad (Gujarat)", "Tharamangalam (Tamil Nadu)", "Tharangambadi (Tamil Nadu)", "Theni Allinagaram (Tamil Nadu)", "Thirumangalam (Tamil Nadu)", "Thirunindravur (Tamil Nadu)", "Thiruparappu (Tamil Nadu)", "Thirupuvanam (Tamil Nadu)", "Thiruthuraipoondi (Tamil Nadu)", "Thiruvalla (Kerala)", "Thiruvallur (Tamil Nadu)", "Thiruvarur (Tamil Nadu)", "Thiruvananthapuram (Kerala)", "Thrissur (Kerala)", "Thodupuzha (Kerala)", "Thoothukudi (Tamil Nadu)", "Thoubal (Manipur)", "Thuraiyur (Tamil Nadu)", "Tikamgarh (Madhya Pradesh)", "Tilda Newra (Chhattisgarh)", "Tilhar (Uttar Pradesh)", "Tindivanam (Tamil Nadu)", "Tinsukia (Assam)", "Tiptur (Karnataka)", "Tirora (Maharashtra)", "Tiruchendur (Tamil Nadu)", "Tiruchengode (Tamil Nadu)", "Tiruchirappalli (Tamil Nadu)", "Tirukalukundram (Tamil Nadu)", "Tirukkoyilur (Tamil Nadu)", "Tirunelveli (Tamil Nadu)", "Tirupati (Andhra Pradesh)", "Tirupathur (Tamil Nadu)", "Tirupathur (Tamil Nadu)", "Tiruppur (Tamil Nadu)", "Tirur (Kerala)", "Tiruttani (Tamil Nadu)", "Tiruvannamalai (Tamil Nadu)", "Tiruvethipuram (Tamil Nadu)", "Tirwaganj (Uttar Pradesh)", "Titlagarh (Orissa)", "Tittakudi (Tamil Nadu)", "Todabhim (Rajasthan)", "Todaraisingh (Rajasthan)", "Tohana (Haryana)", "Tonk (Rajasthan)", "Tuensang (Nagaland)", "Tuljapur (Maharashtra)", "Tulsipur (Uttar Pradesh)", "Tumkur (Karnataka)", "Tumsar (Maharashtra)", "Tundla (Uttar Pradesh)", "Tuni (Andhra Pradesh)", "Tura (Meghalaya)", "Uchgaon (Maharastra)", "Udaipur (Rajasthan)", "Udaipur (Tripura)", "Udaipurwati (Rajasthan)", "Udgir (Maharastra)", "Udhagamandalam (Tamil Nadu)", "Udhampur (Jammu and Kashmir)", "Udumalaipettai (Tamil Nadu)", "Udupi (Karnataka)", "Ujhani (Madhya Pradesh)", "Ujjain (Madhya Pradesh)", "Umarga (Maharastra)", "Umaria (Madhya Pradesh)", "Umarkhed (Maharastra)", "Umarkote (Orissa)", "Umbergaon (Gujarat)", "Umred (Maharastra)", "Umreth (Gujarat)", "Una (Gujarat)", "Unjha (Gujarat)", "Unnamalaikadai (Tamil Nadu)", "Unnao (Uttar Pradesh)", "Upleta (Gujarat)", "Uran (Maharashtra)", "Uran Islampur (Maharashtra)", "Uravakonda (Andhra Pradesh)", "Urmar Tanda (Punjab)", "Usilampatti (Tamil Nadu)", "Uthamapalayam (Tamil Nadu)", "Uthiramerur (Tamil Nadu)", "Utraula (Uttar Pradesh)", "Vadakkuvalliyur (Tamil Nadu)", "Vadalur (Tamil Nadu)", "Vadgaon Kasba (Maharastra)", "Vadipatti (Tamil Nadu)", "Vadnagar (Gujarat)", "Vadodara (Gujarat)", "Vaijapur (Maharastra)", "Vaikom (Kerala)", "Valparai (Tamil Nadu)", "Valsad (Gujarat)", "Vandavasi (Tamil Nadu)", "Vaniyambadi (Tamil Nadu)", "Vapi city (Gujarat)", "Vapi city (Gujarat)", "Varanasi (Uttar Pradesh)", "Varkala (Kerala)", "Vasai (Maharastra)", "Vadakara (Kerala)", "Vedaranyam (Tamil Nadu)", "Vellakoil (Tamil Nadu)", "Vellore (Tamil Nadu)", "Venkatagiri (Andra Pradesh)", "Veraval (Gujarat)", "Vicarabad (Andra Pradesh)", "Vidisha (Madhya Pradesh)", "Vijainagar (Rajasthan)", "Vijapur (Gujarat)", "Vijayapura (Karnataka)", "Vijayawada (Andra Pradesh)", "Vikramasingapuram (Tamil Nadu)", "Viluppuram (Tamil Nadu)", "Vinukonda (Andra Pradesh)", "Viramgam (Gujarat)", "Virar (Maharastra)", "Virudhachalam (Tamil Nadu)", "Virudhunagar (Tamil Nadu)", "Visakhapatnam (Andra Pradesh)", "Visnagar (Gujarat)", "Viswanatham (Tamil Nadu)", "Vita (Maharastra)", "Vizianagaram (Andra Pradesh)", "Vrindavan (Uttar Pradesh)", "Vyara (Gujarat)", "Wadgaon Road (Maharashtra)", "Wadhwan (Gujarat)", "Wadi (Karnataka)", "Wai (Maharashtra)", "Wanaparthy (Andra Pradesh)", "Wani (Maharashtra)", "Wankaner (Gujarat)", "Warangal (Andra Pradesh)", "Wara Seoni (Madhya Pradesh)", "Wardha (Maharashtra)", "Warhapur (Uttar Pradesh)", "Warora (Maharashtra)", "Warud (Maharashtra)", "Washim (Maharashtra)", "Warisaliganj (Bihar)", "Wokha (Nagaland)", "Yadgir (Karnataka)", "Yamunanagar (Haryana)", "Yanam (Pondicherry)", "Yavatmal (Maharastra)", "Yawal (Maharastra)", "Yellandu (Andhra Pradesh)", "Yemmiganur (Andhra Pradesh)", "Yerraguntla (Andhra Pradesh)", "Yevla (Maharashtra)", "Zahirabad (Andhra Pradesh)", "Zaidpur (Uttar Pradesh)", "Zamania (Uttar Pradesh)", "Zira (Punjab)", "Zirakpur (Punjab)", "Zunheboto (Nagaland)"};
	public static String[] getCity() {
		return CITY;
	}
}