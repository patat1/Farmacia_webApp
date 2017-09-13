package farmacia_webapp

class MainMenuTagLib {
    static defaultEncodeAs = "raw"
    def menuMain = {
        def homeURL
        switch (session.usertype){
            case "TF":
                homeURL = "../homepage_TF/index.gsp"
                break
            case "DF":
                homeURL = "../homepage_DF/index.gsp"
                break
            case "OB":
                homeURL = "../homepage_OB/index.gsp"
                break
            case "REG":
                homeURL = "../homepage_regione/index.gsp"
                break
            default:
                homeURL = "#"
                break
        }
        if (session.usertype=="REG"){
            out << "<div class=\"section\">\n" +
                    "      <div class=\"container\">\n" +
                    "        <div class=\"row\">\n" +
                    "          <div class=\"col-md-12\">\n" +
                    "            <ul class=\"nav nav-pills\">\n" +
                    "              <li class=\"active\">\n" +
                    "                <a href=\"" + homeURL + "\">Home</a>\n" +
                    "              </li>\n" +
                    "              <li>\n" +
                    "                <a href=\"#\">Messaggi</a>\n" +
                    "              </li>\n" +
                    "            </ul>\n" +
                    "          </div>\n" +
                    "        </div>\n" +
                    "      </div>\n" +
                    "    </div"
        }else{
            out << "<div class=\"section\">\n" +
                    "      <div class=\"container\">\n" +
                    "        <div class=\"row\">\n" +
                    "          <div class=\"col-md-12\">\n" +
                    "            <ul class=\"nav nav-pills\">\n" +
                    "              <li class=\"active\">\n" +
                    "                <a href=\"" + homeURL + "\">Home</a>\n" +
                    "              </li>\n" +
                    "              <li>\n" +
                    "                <a href=\"#\">Messaggi</a>\n" +
                    "              </li>\n" +
                    "              <li>\n" +
                    "                <a href=\"../carrello/index.gsp\">Carrello</a>\n" +
                    "              </li>\n" +
                    "            </ul>\n" +
                    "          </div>\n" +
                    "        </div>\n" +
                    "      </div>\n" +
                    "    </div"
        }
    }
}
