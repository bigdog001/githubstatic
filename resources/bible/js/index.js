 const sutras_ = [sutra_1,sutra_2,sutra_3,sutra_4,sutra_5,sutra_6,sutra_7,sutra_8,sutra_9,sutra_10,
                     sutra_11,sutra_12,sutra_13,sutra_14,sutra_15,sutra_16,sutra_17,sutra_18,sutra_19,sutra_20,
                     sutra_21,sutra_22,sutra_23,sutra_24,sutra_25,sutra_26,sutra_27,sutra_28,sutra_29,sutra_30,
                     sutra_31,sutra_32,sutra_33,sutra_34,sutra_35,sutra_36,sutra_37,sutra_38,sutra_39,sutra_40,
                     sutra_41,sutra_42,sutra_43,sutra_44,sutra_45,sutra_46,sutra_47,sutra_48,sutra_49,sutra_50,
                     sutra_51,sutra_52,sutra_53,sutra_54,sutra_55,sutra_56,sutra_57,sutra_58,sutra_59,sutra_60,
                     sutra_61,sutra_62,sutra_63,sutra_64,sutra_65,sutra_66,
                    ];
    const sutra_en = [sutra_en_1,sutra_en_2,sutra_en_3,sutra_en_4,sutra_en_5,sutra_en_6,sutra_en_7,sutra_en_8,sutra_en_9,sutra_en_10,
                        sutra_en_11,sutra_en_12,sutra_en_13,sutra_en_14,sutra_en_15,sutra_en_16,sutra_en_17,sutra_en_18,sutra_en_19,sutra_en_20,
                        sutra_en_21,sutra_en_22,sutra_en_23,sutra_en_24,sutra_en_25,sutra_en_26,sutra_en_27,sutra_en_28,sutra_en_29,sutra_en_30,
                        sutra_en_31,sutra_en_32,sutra_en_33,sutra_en_34,sutra_en_35,sutra_en_36,sutra_en_37,sutra_en_38,sutra_en_39,sutra_en_40,
                        sutra_en_41,sutra_en_42,sutra_en_43,sutra_en_44,sutra_en_45,sutra_en_46,sutra_en_47,sutra_en_48,sutra_en_49,sutra_en_50,
                        sutra_en_51,sutra_en_52,sutra_en_53,sutra_en_54,sutra_en_55,sutra_en_56,sutra_en_57,sutra_en_58,sutra_en_59,sutra_en_60,
                        sutra_en_61,sutra_en_62,sutra_en_63,sutra_en_64,sutra_en_65,sutra_en_66
    ];                

    sutras_.forEach((msg, index,sutra) => {
        //console.log(`=============================>Sutra ${index+1} has ${msg.length} Chapters`);
        msg.forEach((msg_x, index_,sutra_) => {
            //const msg_length = msg_x.split(/\r?\n/).length;console.log(`length at index ${index_+1}: ${msg_length}`);
        });
    });
    var fatal_size = 0;

	for(var j=0; j<66;j++){
	 const target_en = sutra_en[j] ;
    	 const target_cn = sutras_[j]  ;
		 if(target_en.length !== target_cn.length){
	        console.log(`Fatal: total sutra size not match,en:${target_en.length},cn:${target_cn.length}`);
	        fatal_size++;
	    }
	    for(var i = 0;i< target_en.length;i++){
	        const en_length = target_en[i].split(/\r?\n/).length;
	        const cn_length = target_cn[i].split(/\r?\n/).length;
	        if(en_length !== cn_length){
	            console.log(`Fatal:${j+1}-->${i+1},en:${en_length},cn:${cn_length} `);
	            fatal_size++;
	        }
	    }
	}
    if(fatal_size === 0){
    console.log("checking ALL GOOD ");
    }

		
         

        document.addEventListener('DOMContentLoaded', () => {
            const targetChapter = 1;
            const targetParagraph = 1;
            displayChpterItem( targetChapter , targetParagraph);
    });

     function displaySubtitle(subtitle){
        const subtitleEl = document.getElementById("pageFooter");
        subtitleEl.innerText = subtitle;

    }

    function BuildDictionaryItem(sutraEN){
        var dictionary_text = "";
        const words = (sutraEN.match(/\b[\w']+\b/g) || []);
        // console.log(words.map((w,i)=>`${i+1}. ${w}\n`).join('')); 
        dictionary_text = words.map((w,i)=>` &nbsp;<a target="_blank" href="https://translate.google.com/?sl=en&tl=zh-CN&text=${encodeURIComponent(w)}&op=translate" >${w}</a> &nbsp;`).join('');
        //console.log(`dictionary_text:${dictionary_text}`); 
        return dictionary_text;
    }

	var player_cn ;
	var player_en;
	var player_cn_flag = 0;
	var player_en_flag = 0;
	function playcn(){
		if(player_cn_flag === 0){
			console.log("cn mp3 play..");
			player_cn.play();
			player_cn_flag = 1 ;
		}else{
			console.log("cn mp3 stop..");
			player_cn.pause();
			player_cn_flag = 0 ;
		}
    }

	function playen(){
         if(player_en_flag === 0){
			 console.log("en mp3 play..");
			player_en.play();
			player_en_flag = 1 ;
		}else{
			console.log("en mp3 stop..");
			player_en.pause();
			player_en_flag = 0 ;
		}
    }

	function audioPlay(){
		console.log("audioPlay.......");
		const audioSelect = document.getElementById("audioSelect");
        const selectedValue = audioSelect.value;
		console.log(`audioPlay...${selectedValue}....`);
		
	}

    function displayChpterItem( targetChapter , targetParagraph){
        const sutraCNs = sutras_[targetChapter-1][targetParagraph-1].split(/\r?\n/); ;
        const sutraENs = sutra_en[targetChapter-1][targetParagraph-1].split(/\r?\n/); ;
        const size_sutra = sutraCNs.length;
        console.log(`size_sutra:${size_sutra}`)
        document.getElementById("sutra_title").innerText = `${targetChapter} ${sutra_titles[targetChapter-1][1]} / Chapter ${targetParagraph}`;
        var body_data = "";
        for(var k = 0;k<size_sutra;k++){
            // console.log(`${sutraENs[k]}`)
            // console.log(`${sutraCNs[k]}`)
            const dictionary_item= "<p class='dictionary_text' style='display:none;'>"+ BuildDictionaryItem(sutraENs[k])+"</p>";
            body_data += `<span class="sutra_en_items" id="sutra_en_text_${targetChapter}_${k}" onClick="displaySubtitle('${sutraCNs[k]}')">${sutraENs[k]}</span> <p style="display:none;" class="sutra_cn_text">${sutraCNs[k]}</p> ${dictionary_item} <input class="my-comment" type="text" id="comment_${k}" style="width:70%;display: none;" value="N/A"/><br/>`;
        }
		
		player_cn = new Audio(cn_mp3_urls[targetChapter-1][targetParagraph-1]);
		player_en = new Audio(en_mp3_urls[targetChapter-1][targetParagraph-1]);
		body_data+= `<br/><br/> <span onclick=playcn() >@</span> &nbsp;&nbsp; <span onclick=playen() >@En</span><br/><br/>`;
        const contentEl = document.getElementById("contents");
        contentEl.innerHTML = body_data;
        const subChapterSelect = document.getElementById("subChapterSelect");
         if(!subChapterSelect.value){
                    for(let i = 0; i < 50; i++){
                    const option = document.createElement("option");
                    option.value = i+1;
                    const xx = sutra_en[0][i].split(/\r?\n/).length; 
                    option.textContent = `Chapter ${i+1} has ${xx}`;
                    subChapterSelect.appendChild(option);
                }
         }
    }

    function loadSubChapter(){
        const bookSelect = document.getElementById("bookSelect");
        const selectedValue = bookSelect.value;
        const chapterLength = sutra_en[selectedValue-1].length;
        const subChapterSelect = document.getElementById("subChapterSelect");
        
        console.log(`Loaded book ${selectedValue}: chapter:${subChapterSelect.value}`);
        displayChpterItem(selectedValue,subChapterSelect.value);
    }

    function loadBook(){
        const bookSelect = document.getElementById("bookSelect");
        const selectedValue = bookSelect.value;
        console.log(`Selected book: ${selectedValue}`);
        const chapterLength = sutra_en[selectedValue-1].length; 
        console.log(`Total chapters in selected book: ${chapterLength}`);

        const subChapterSelect = document.getElementById("subChapterSelect");
        subChapterSelect.innerHTML = "";
        for(let i = 1; i <= chapterLength; i++){
            const option = document.createElement("option");
            option.value = i;
            const xx = sutra_en[selectedValue-1][i-1].split(/\r?\n/).length; 
            option.textContent = `Chapter ${i} has ${xx}`;
            subChapterSelect.appendChild(option);
        }
        displayChpterItem(selectedValue,1);
    }

    function buildComments(){
        const bookSelect = document.getElementById("bookSelect").value;
        const subChapterSelect = document.getElementById("subChapterSelect").value;
        console.log(`Selected book: ${bookSelect}`);
        console.log(`Selected sub-chapter: ${bookSelect}/${subChapterSelect}`);
        const xLength = sutras_[bookSelect-1][subChapterSelect-1].split(/\r?\n/).length
        var all_Comments = "\n";
    
        for(var k = 0;k<xLength;k++){
            const cK = document.getElementById(`comment_${k}`).value;
            all_Comments+=`${k+1} ${cK}\n`;
        }
        console.log(all_Comments+"\n");

//

    }

    function handleShowCN(){
        const checkbox = document.getElementById("showCN");
        if (checkbox.checked) {
             console.log("Show CN checked");
             document.querySelectorAll('p.sutra_cn_text').forEach(input => {
                 input.style.display = 'block';
             });
        } else {
            document.querySelectorAll('p.sutra_cn_text').forEach(input => {
                 input.style.display = 'none';
             });
        }
    }

    function fullScreen(){
        if (!document.fullscreenElement) {
            document.documentElement.requestFullscreen();
        } else {
            if (document.exitFullscreen) {
                document.exitFullscreen();
            }
        }
	}

    function handleShowComment(){
        const checkbox = document.getElementById("showComment");
         if (checkbox.checked) {
             console.log("Show Comment checked");
             document.querySelectorAll('input.my-comment').forEach(input => {
                 input.style.display = 'block';
             });
        } else {
            console.log("Show Comment unchecked");
            document.querySelectorAll('input.my-comment').forEach(input => {
                 input.style.display = 'none';
             });
        }
    }

    function handleShowDictionary(){
        const checkbox = document.getElementById("showDictionary");
         if (checkbox.checked) {
             console.log("Show Dictionary checked");
             document.querySelectorAll('p.dictionary_text').forEach(input => {
                 input.style.display = 'block';
             });
        } else {
            console.log("Show Dictionary unchecked");
            document.querySelectorAll('p.dictionary_text').forEach(input => {
                 input.style.display = 'none';
             });
        }
    }

   


    

// const anotherText = "First line\r\nSecond line";
// const anotherLines = anotherText.split(/\r?\n/);
// console.log(anotherLines);
// Output: ["First line", "Second line"]
