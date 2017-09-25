package farmacia_webapp

class StatisticsTagLib {
    static defaultEncodeAs = "raw"

    def statisticTable = {
        int total = 0, scontrino = 0, ricetta = 0, ricette = 0
        def totfarm
        if (session.usertype=="REG")
            total = Acquisto.executeQuery("from Acquisto").size()
        else
            total = Acquisto.executeQuery("from Acquisto as aq, Utente as ut where aq.idUtente = ut.id and ut.idFarmacia = ?", [session.farmacia]).size()
        out <<  "                        <li class=\"media\">\n" +
                "                        <a class=\"pull-left\" href=\"#\"><img class=\"media-object\" src=\"../images/invoice.png\" height=\"64\" width=\"64\"></a>\n" +
                "                        <div class=\"media-body\">\n" +
                "                            <h4 class=\"media-heading\">Acquisti complessivi</h4>\n" +
                "                            <p>" + total + "</p>\n" +
                "                        </div>\n" +
                "                    </li>"
        if (session.usertype=="REG")
            totfarm = InScontrino.executeQuery("from InScontrino")
        else{
            totfarm = InScontrino.executeQuery("select scon.quantità from InScontrino as scon, Utente as ut, Acquisto as aq where aq.idUtente = ut.id and ut.idFarmacia = ? and scon.idAcquisto=aq.id", [session.farmacia])
            if (totfarm.size()>0)
                for (int i=0; i<totfarm.size(); i++)
                    scontrino += totfarm.getAt(i)
        }
        out <<  "                        <li class=\"media\">\n" +
                "                        <a class=\"pull-left\" href=\"#\"><img class=\"media-object\" src=\"../images/pills.png\" height=\"64\" width=\"64\"></a>\n" +
                "                        <div class=\"media-body\">\n" +
                "                            <h4 class=\"media-heading\">Farmaci venduti in totale</h4>\n" +
                "                            <p>" + scontrino + "</p>\n" +
                "                        </div>\n" +
                "                    </li>"
        if (session.usertype=="REG")
            ricetta = InScontrino.executeQuery("from InScontrino")
        else{
            ricetta = InScontrino.executeQuery("from InScontrino as scon, Utente as ut, Acquisto as aq, Ricetta as rc where aq.idUtente = ut.id and ut.idFarmacia = ? and scon.idAcquisto=aq.id and scon.id=rc.idScontrino", [session.farmacia]).size()
        }
        out <<  "                        <li class=\"media\">\n" +
                "                        <a class=\"pull-left\" href=\"#\"><img class=\"media-object\" src=\"../images/doctor.png\" height=\"64\" width=\"64\"></a>\n" +
                "                        <div class=\"media-body\">\n" +
                "                            <h4 class=\"media-heading\">Farmaci con ricetta</h4>\n" +
                "                            <p>" + ricetta + "</p>\n" +
                "                        </div>\n" +
                "                    </li>"
        if (session.usertype=="REG")
            ricette = InScontrino.executeQuery("from InScontrino")
        else{
            ricette = InScontrino.executeQuery("from InScontrino as scon, Utente as ut, Acquisto as aq, Ricetta as rc where aq.idUtente = ut.id and ut.idFarmacia = ? and scon.idAcquisto=aq.id and scon.id=rc.idScontrino group by rc.codiceRicetta", [session.farmacia]).size()
        }
        out <<  "                        <li class=\"media\">\n" +
                "                        <a class=\"pull-left\" href=\"#\"><img class=\"media-object\" src=\"../images/stethoscope.png\" height=\"64\" width=\"64\"></a>\n" +
                "                        <div class=\"media-body\">\n" +
                "                            <h4 class=\"media-heading\">Ricette totali</h4>\n" +
                "                            <p>" + ricette + "</p>\n" +
                "                        </div>\n" +
                "                    </li>"

        out <<  "                        <li class=\"media\">\n" +
                "                        <a class=\"pull-left\" href=\"#\"><img class=\"media-object\" src=\"../images/media.png\" height=\"64\" width=\"64\"></a>\n" +
                "                        <div class=\"media-body\">\n" +
                "                            <h4 class=\"media-heading\">Numero medio di farmaci per ricetta</h4>\n" +
                "                            <p>" + total + "</p>\n" +
                "                        </div>\n" +
                "                    </li>"
    }
}
