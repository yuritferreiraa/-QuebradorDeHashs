/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import view.NewPage;

/**
 *
 * @author dogma
 */
public class test {
    
    public static void main(String args []) {
        
        ThreadManeger tm;
        Thread thrd;
        String hashs[] = {
            "01499346f9267b51e35095365aed4f15",
            "02df778c4e10cdbccf0d0a7ba3f0e896",
            "05dc54fe448e122a4ffc072989c6a4da",
            "05e124f4627deea91cd084e69bd59e70",
            "063e135edd3573c0628a5895ef1c21e4",
            "0a608d375b0c0d615b258c479ede7646",
            "0a76d8749da8f67c37b6a3678d45ce9a",
            "118d3b84ae7f0abcd6c428d08de40327",
            "11a2d0f6d8bb89b254b53577f0054bd6",
            "13240457817d091164402b9604824b67",
            "15c15c7d610a6c3b6aa8b78694b0d6e1",
            "19d6ebafc1e11bea79fb2b85aa760ad9",
            "1ad986911cd5e67c70af2d16e40f5690",
            "1d867c84d76d2c19579c75e6e4f254bf",
            "2271dc8fa2a6ff3b4c23180a66c480dc",
            "229ae56bf5c7e60a1d0db30b423e6af6",
            "22f3c20a643b0c7379e73da5e0021877",
            "24d9e03366dcce1db9368167c7db561e",
            "27faa2d4a2f82da34071354147266386",
            "2b8160cf839671250fc0dabac7cc1d4e",
            "2f4278d6d27c99dc212f23093ae9ac8e",
            "31be29a3d43701323c50de65d71af097",
            "34751c79b023a5da62e40f84b39d7152",
            "36510ae837f23c4da6e541a3e8edafb8",
            "3a4d92a1200aad406ac50377c7d863aa",
            "3a53e1c5e3d326feea121eb66a760a0b",
            "3b9fd53e2cddd988bfaab9b2bccf8a68",
            "3be0d22b588d2d3a079eda46c9873e04",
            "3c2effe3f1157e5038b1dd0687d15957",
            "3c455c4db36d7a20790ce67d6e40769b",
            "3d945423f8e9496c429a5d8c65b4604f",
            "48a58da106a36dd10852b229dfdc2088",
            "4998654b7d255461cd5110d5dcbac05b",
            "4ca6f0fd24288c5cd2062bac44529cfe",
            "4ead786036ddf05758520acaeffeae6c",
            "502f4a210a4801bcd2b3d2ab202f990b",
            "50e318711a43cc8e965d90337f49deb8",
            "5438364b0199c0004432ac04dae29525",
            "54d9d99fad304a6d0329fc1fb6bdb517",
            "57281ba3a7c79147d074bf82357038e4",
            "58396401112fa9245099fff81ba63dec",
            "5c55036d0b9dadec219f65c9d8d420c1",
            "5d9113ee03c7dbc37aa7c924f096a161",
            "60bb1f9914c26fb929b724398e5d2f66",
            "60f991ba32d0fc91a57499bd74304151",
            "655f7cff3e9532f4a034500bb3205a5f",
            "6684c3a42197530e7f2930c6c9b20572",
            "69e80cd4d08679e2739f801516bfb170",
            "6af5f30627d3823099c2541d0b9326fc",
            "6cfe61694ee1bb13ae719d47c2f80b7a",
            "6d73458e7cfb8269e0b91ed656451703",
            "70d06803ce18c714944dac18cd58f292",
            "733d7be2196ff70efaf6913fc8bdcabf",
            "76a2173be6393254e72ffa4d6df1030a",
            "778252ea76f7f2e5dc56392f41dfb629",
            "813c9e77c864c7cfc8b2ad9472c1dde6",
            "81dc9bdb52d04dc20036dbd8313ed055",
            "827ccb0eea8a706c4c34a16891f84e7b",
            "8343f6af1f2313770bea1954bbf3b3c6",
            "864a77ce17937bf629637a939b69da64",
            "8ab337e58e81398a0d5af82a4e9a0c79",
            "8c1200ce22d3d580f91021403c1a85e7",
            "8f04712639a44a796d200da1879e9086",
            "920d22766c3e612e964ac8eafc14a0d6",
            "9605eb53e0da2675998ad751baf255ce",
            "96db69b0fff794de363fbb73929ac604",
            "972c16f442eba60469680bf869dd6a89",
            "9a47bbe7bc568d5f478a2846514a4df5",
            "9b82b6de580184657e6d95c4cfb2f337",
            "9cda986cec137d423863c2f9fca7c543",
            "9cdf2b2340a1dd11c296420a40a73e2d",
            "9d495d6a637e83e277de834c2b31a8a1",
            "9de37a0627c25684fdd519ca84073e34",
            "a11e3ff6ce4b8296b9c23fcb6900e176",
            "a2225930d7d115b316a571f5a2bff627",
            "a284236e525bff59c8956266df0ac1ea",
            "a3022be1daeeb8a8f93148db018e1ebe",
            "a4ab812db5e84ec4280a2067a0e009a8",
            "a4e4022b0aa2df1348df56e09093041a",
            "a6277e6334d4fe8c60c95af0cdf20217",
            "a7cd52701825a8c359b3b4cf586442f6",
            "a9cec9eeae78b260c010bc84b79a2330",
            "ab781dfff42eeee8cb9313ae4884cd9f",
            "abf8b71fd5f760e6f29a304936d3c314",
            "aee9e38cb4d40ec2794542567539b4c8",
            "b12e525bd4dea0ead8c18672b04f61d4",
            "b28f6f54dd7093e5c9c619cfdfa00152",
            "b6237e0583f7a0604ffae20003e5ec5a",
            "b679bd0e6ff4111352fa31c0397fd655",
            "b73fdaa1fb7669da760b49600c45d9be",
            "b869c6089d0011babb16d4ac79d15550",
            "bd4f0205aa13236859d9c7e680ac79fa",
            "bee4dc86f94515966d17479983ebb06e",
            "c25a57af7ba864e66fd702e27d149d89",
            "c41613341914d2a60bf6946c21fb8559",
            "ca4abb07a2e12b9008c49953db2d0c0d",
            "cb22aa3283b4d5c02c261103b81c64cf",
            "d13c14bfdd483cae63e79bc7399e7c85",
            "d3e15eda41a8096cf5824c12bceffcd8",
            "d79096188b670c2f81b7001f73801117",
            "da1f4f53f066ce62294ff75fc00b15c8",
            "dcaff46aec8f457fa874d0b7a04960be",
            "dcb1d92a7ca036034f3a39f9ef26fe40",
            "dfa8327f5bfa4c672a04f9b38e348a70",
            "dface1c59566d159d68918eb52e25d91",
            "e16ad9b2312744576485c258973ed048",
            "e2b8c6659199d2cde5c594e1ffb67fe2",
            "e2ba49209f8ce01f1025d5f14400bf5b",
            "e2fc714c4727ee9395f324cd2e7f331f",
            "e68d3c6431bf1e25eced5d26c301f68d",
            "e9510081ac30ffa83f10b68cde1cac07",
            "eb30670bb0e1c5edee08135db93efa77",
            "f21ee05fa5d24c7de11e4aca9700aa8f",
            "f38fef4c0e4988792723c29a0bd3ca98",
            "f3be94f16fd6d05b564b93fc8836fa88",
            "f3f3aa37990860260b2e6ceeaf672837",
            "f4581fc51da80319fd4525c6cbb1c80b",
            "f916e6a2ef1e57ca076f399823874f96",
            "fa92a2bac50fcc80b52265597d46b1f1",
            "fc485bfdf608d704f0f11ca880840127",
            "fdb594b1adfe6c1e1692a75cab22f0de",
            "fe60293345d3e4f675441f1c4424ed4e",
            "ff434d71061293390990711649b9dfd9"};
        // yuritferreira@gmail.com
        //for (int j = 0; j < hashs.length; j++) {
            tm =new ThreadManeger(8, 8, hashs);
            thrd = new Thread(tm);
            thrd.start();
        //}
    }
}