let kantoPrefectureListVisible = false;

function clickreal() {
}

function clickeria() {
    console.log("clickeria function called");

    const regionList = document.getElementById("regionList");
    const prefectureList = document.getElementById("prefectureListKanto");

    console.log("regionList.style.display:", regionList.style.display);
    console.log("prefectureList.style.display:", prefectureList.style.display);

    if (regionList.style.display === "none" || regionList.style.display === "") {
        const regions = ["北海道", "東北", "中部", "関東", "中国", "近畿", "九州", "四国", "沖縄"];

        regionList.innerHTML = "";
        for (let i = 0; i < regions.length; i++) {
            const regionLink = document.createElement("a");
            regionLink.href = "#";
            regionLink.className = "regionLink";
            regionLink.id = "region" + i;
            regionLink.onclick = function() {
                clickreg(i);
            };
            regionLink.innerText = regions[i];

            regionList.appendChild(regionLink);
            regionList.appendChild(document.createTextNode(" "));
        }

        regionList.style.display = "block";
        prefectureList.style.display = kantoPrefectureListVisible ? "block" : "none";
    } else {
        regionList.style.display = "none";
        prefectureList.style.display = "none";
    }
}


function clickreg(regionIndex) {
    const prefectureList = document.getElementById("prefectureListKanto");

    if (regionIndex === 3) {
        const prefectures = ["東京都", "神奈川県", "千葉県", "埼玉県", "茨城県", "栃木県", "群馬県"];

        prefectureList.innerHTML = "";
        for (let i = 0; i < prefectures.length; i++) {
            const prefectureLink = document.createElement("a");
            prefectureLink.href = "#";
            prefectureLink.id = "prefectureKanto" + (i + 1);
            prefectureLink.innerText = prefectures[i];

            prefectureList.appendChild(prefectureLink);
            prefectureList.appendChild(document.createTextNode(" "));
        }

        prefectureList.style.display = "block";
        kantoPrefectureListVisible = true;
    } else {
        prefectureList.style.display = "none";
        kantoPrefectureListVisible = false;
    }
}
