    const google_dictionary_url = "";//https://translate.google.com/?sl=en&tl=zh-CN&text=ok&op=translate
    const youdao_dictionary_url = "";
    function BuildDictionaryItem(content){
        const value = new URLSearchParams(location.search).get("dic");

        var dictionary_text = "";
        const words = (content.match(/\b[\w']+\b/g) || []);
        // console.log(words.map((w,i)=>`${i+1}. ${w}\n`).join(''));
        //dictionary_text = words.map((w,i)=>` &nbsp;<a target="_blank" href="https://translate.google.com/?sl=en&tl=zh-CN&text=${encodeURIComponent(w)}&op=translate" >${w}</a> &nbsp;`).join('');
        if(value){
           //console.log(`dic:${value}`);
           if(value === "1"){
                //https://www.youdao.com/result?word=good&lang=en
                dictionary_text = words.map((w,i)=>` &nbsp;<a target="_blank" href="https://www.youdao.com/result?lang=en&word=${encodeURIComponent(w)}" >${w}</a> &nbsp;`).join('');
           }else if(value === "2"){
               // some other dic
           }else{
            dictionary_text = words.map((w,i)=>` &nbsp;<a target="_blank" href="https://translate.google.com/?sl=en&tl=zh-CN&text=${encodeURIComponent(w)}&op=translate" >${w}</a> &nbsp;`).join('');
           }
        }else{
            dictionary_text = words.map((w,i)=>` &nbsp;<a target="_blank" href="https://translate.google.com/?sl=en&tl=zh-CN&text=${encodeURIComponent(w)}&op=translate" >${w}</a> &nbsp;`).join('');
        }
        //console.log(`dictionary_text:${dictionary_text}`);
        return dictionary_text;
    }

    function showDictionary(itemId){
        console.log(itemId);
       let x = document.getElementById(itemId+"_dic");
        console.log(`showCommentById:${x.style.display}`);
        if(x.style.display === 'block'){
            x.style.display = 'none';
        }else{
            x.style.display = 'block';
        }
    }

    function buildContent(content_array ,targetChapter) {

        const selected_chapter_sentences = content_array[targetChapter ].content.split(/\r?\n/);
        const size_selected_chapter_sentences = selected_chapter_sentences.length;
        let display_content = "";
        for (let k = 0; k < size_selected_chapter_sentences; k++) {
            const item_id =`content_item_${targetChapter}_${k}`;
            if(selected_chapter_sentences[k].length == 0){
                display_content+="<br/>";
            }else {
                display_content += `<span id="${item_id}" class="content_item" onclick="showDictionary('${item_id}')">${selected_chapter_sentences[k]} </span> <p style="display:none;" id="${item_id}_dic" class="content_item_dictionary">${BuildDictionaryItem(selected_chapter_sentences[k])}</p>`;
            }

        }
        document.getElementById("contents").innerHTML = display_content;
    }

    let targetContentArray ;
    function selectChapter(){
        const index = document.getElementById("chapterSelect").value
        document.getElementById("chapter_title").innerHTML = targetContentArray[index].title_en;
        buildContent(targetContentArray, index);
    }

    function buildChapterList(content_array){
        const subChapterSelect = document.getElementById("chapterSelect");
        if(!subChapterSelect.value){
            for(let i = 0; i < content_array.length; i++){
                const option = document.createElement("option");
                option.value = i;
                const title = content_array[i].title_en;
                option.textContent = `Chapter ${i+1} - ${title}`;
                subChapterSelect.appendChild(option);
            }
        }
    }