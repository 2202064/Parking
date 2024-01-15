
  document.getElementById('firstSelect').addEventListener('change', function(event) {

    const selectedValue = event.target.value;

    // ダミークリア
    const secondSelect = document.getElementById('secondSelect');
    secondSelect.innerHTML = '';

    if (selectedValue === '北海道') {
      //secondSelect非表示
      secondSelect.style.display = 'none';
      thirdSelect.style.display = 'none';
    } else {
      //secondSelect表示
      secondSelect.style.display = 'block';
      thirdSelect.style.display = 'block';


      if (selectedValue === '関東') {
    	addOption(secondSelect, '都道府県を選択', '');
        addOption(secondSelect, '東京', '東京');
        addOption(secondSelect, '茨城', '茨城');
        addOption(secondSelect, '埼玉', '埼玉');
        addOption(secondSelect, '栃木', '栃木');
        addOption(secondSelect, '千葉', '千葉');
        addOption(secondSelect, '群馬', '群馬');
        addOption(secondSelect, '神奈川', '神奈川');
      } else if (selectedValue === '四国') {
    	addOption(secondSelect, '都道府県を選択', '');
        addOption(secondSelect, '愛媛', '愛媛');
        addOption(secondSelect, '徳島', '徳島');
        addOption(secondSelect, '高知', '高知');
        addOption(secondSelect, '香川', '香川');
      } else if (selectedValue === '九州') {
    	addOption(secondSelect, '都道府県を選択', '');
        addOption(secondSelect, '熊本', '熊本');
        addOption(secondSelect, '福岡', '福岡');
        addOption(secondSelect, '佐賀', '佐賀');
        addOption(secondSelect, '長崎', '長崎');
        addOption(secondSelect, '大分', '大分');
        addOption(secondSelect, '宮崎', '宮崎');
        addOption(secondSelect, '鹿児島', '鹿児島');
      }else if (selectedValue === '東北') {
    	addOption(secondSelect, '都道府県を選択', '');
        addOption(secondSelect, '青森', '青森');
        addOption(secondSelect, '秋田', '秋田');
        addOption(secondSelect, '岩手', '岩手');
        addOption(secondSelect, '宮城', '宮城');
        addOption(secondSelect, '山形', '山形');
        addOption(secondSelect, '宮崎', '宮崎');
        addOption(secondSelect, '福島', '福島');
      }else if (selectedValue === '中部') {
    	addOption(secondSelect, '都道府県を選択', '');
        addOption(secondSelect, '富山', '富山');
        addOption(secondSelect, '石川', '石川');
        addOption(secondSelect, '福井', '福井');
        addOption(secondSelect, '長野', '長野');
        addOption(secondSelect, '岐阜', '岐阜');
        addOption(secondSelect, '静岡', '静岡');
        addOption(secondSelect, '愛知', '愛知');
        addOption(secondSelect, '三重', '三重');
        addOption(secondSelect, '滋賀', '滋賀');
      }else if (selectedValue === '中国') {
    	addOption(secondSelect, '都道府県を選択', '');
        addOption(secondSelect, '島根', '島根');
        addOption(secondSelect, '鳥取', '鳥取');
        addOption(secondSelect, '岡山', '岡山');
        addOption(secondSelect, '広島', '広島');
        addOption(secondSelect, '山口', '山口');
          }
    }
  });

  document.getElementById('secondSelect').addEventListener('change', function(event2) {

	    const selectedValue2 = event.target.value;

	    // ダミークリア
	    const secondSelect = document.getElementById('thirdSelect');
	    thirdSelect.innerHTML = '';

	    if (selectedValue2 === '東京') {
	    	addOption(thirdSelect, '新宿区', '新宿区');
	        addOption(thirdSelect, '台東区', '台東区');
	        addOption(thirdSelect, '中央区', '中央区');
	        addOption(thirdSelect, 'ワセリン', 'ワセリン');
	        addOption(thirdSelect, '江戸川区', '江戸川区');
	        addOption(thirdSelect, '板橋区', '板橋区');
	        addOption(thirdSelect, '目黒区', '目黒区');
	    }else if(selectedValue2 === '茨城'){
	    	addOption(thirdSelect, '水戸市', '水戸市');
	        addOption(thirdSelect, '日立市', '日立市');
	        addOption(thirdSelect, '土浦市', '土浦市');
	        addOption(thirdSelect, '古河市', '古河市');
	        addOption(thirdSelect, '石岡市', '石岡市');
	        addOption(thirdSelect, '結城市', '結城市');
	        addOption(thirdSelect, '竜ヶ崎市', '竜ヶ崎市');
	        addOption(thirdSelect, '下妻市', '下妻市');
	        addOption(thirdSelect, '常総市', '常総市');
	        addOption(thirdSelect, '竜ヶ崎市', '竜ヶ崎市');
	        addOption(thirdSelect, '常陸太田', '常陸太田市');
	        addOption(thirdSelect, '高萩市', '高萩市');
	        addOption(thirdSelect, '笠間市', '笠間市');
	        addOption(thirdSelect, '取手市', '取手市');
	        addOption(thirdSelect, '牛久市', '牛久市');
	        addOption(thirdSelect, 'つくば市', 'つくば市');
	        addOption(thirdSelect, '鹿嶋市', '鹿嶋市');
	        addOption(thirdSelect, '潮来市', '潮来市');
	        addOption(thirdSelect, '守谷市', '守谷市');
	        addOption(thirdSelect, '常陸大宮市', '常陸大宮市');
	        addOption(thirdSelect, '那珂市', '那珂市');
	        addOption(thirdSelect, '筑西市', '筑西市');
	        addOption(thirdSelect, '坂東市', '坂東市');
	        addOption(thirdSelect, '稲木井', '稲木氏');
	        addOption(thirdSelect, 'かすみがうら市', 'かすみがうら市');
	        addOption(thirdSelect, '桜川市', '桜川市');
	        addOption(thirdSelect, '神栖市', '神栖市');
	        addOption(thirdSelect, '行方市', '行方市');
	        addOption(thirdSelect, '鉾田市', '鉾田市');
	        addOption(thirdSelect, 'つくばみらい市', 'つくばみらい市');
	        addOption(thirdSelect, '小美玉市', '小美玉市');
	        addOption(thirdSelect, '茨城町', '茨城町');
	        addOption(thirdSelect, '大洗町', '大洗町');
	        addOption(thirdSelect, '城里町', '城里町');
	        addOption(thirdSelect, '東海村', '東海村');
	        addOption(thirdSelect, '大子町', '大子町');
	        addOption(thirdSelect, '美浦村', '美浦村');
	        addOption(thirdSelect, '阿見町', '阿見町');
	        addOption(thirdSelect, '河内町', '河内町');
	        addOption(thirdSelect, '竜ヶ崎市', '八千代町');
	        addOption(thirdSelect, '五霞町', '五霞町');
	        addOption(thirdSelect, '境町', '境町');
	        addOption(thirdSelect, '利根町', '利根町');

	    }
	  });
  //select関数
  function addOption(selectElement, text, value) {
    const option = document.createElement('option');
    option.textContent = text;
    option.value = value;
    selectElement.appendChild(option);
  }