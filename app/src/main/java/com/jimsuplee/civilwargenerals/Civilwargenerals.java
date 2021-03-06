/**Copyright (C) 2015 Thomas Maher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.jimsuplee.civilwargenerals;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import android.util.Log;
//import android.support.v7.app.ActionBarActivity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
//import android.view.ViewGroup;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.os.Bundle;
//import android.app.Activity;
//import android.view.Menu;
import android.widget.ImageView;
import java.util.HashMap;
//import java.util.Map;
import android.content.Intent;
//import android.view.View;
import android.widget.TextView;
//import android.util.Log;
//import android.widget.Button;
//import android.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.widget.Toast;
import android.database.Cursor;
import android.widget.EditText;
import java.util.List;
import java.util.ArrayList;
//import com.jimsuplee.scottishdistilleries.R;
//import android.widget.Spinner;
//import android.widget.ArrayAdapter;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemSelectedListener;
//import android.R;
//import android.net.Uri;
import android.text.Html;
import android.text.Spanned;


public class Civilwargenerals extends ActionBarActivity {
    static final String TAG = "CWG";
    static String generalChoice = "";
    static String army = "";
    static List<String> carrierSearchList = new ArrayList<String>();
    DBAdapter db;
    HashMap<String,Integer> photoMap = new HashMap<String,Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Log.w(TAG, "In Civilwargenerals_ActionBarActivity_onCreate()");
        super.onCreate(savedInstanceState);
        try {
            String destPath = "/data/data/" + getPackageName() + "/databases";
            File f = new File(destPath);
            if (!f.exists()) {
                f.mkdirs();
                f.createNewFile();
                Toast.makeText(this, "Please Wait...Database Being Created", Toast.LENGTH_LONG).show();
                CopyDB(getBaseContext().getAssets().open("civilwargenerals"), new FileOutputStream(destPath + "/civilwargenerals"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        db = new DBAdapter(this);
        //photoMap.put("abbott_henry_livermore",R.drawable.abc_ab_share_pack_holo_dark);
        photoMap.put("abbott_henry_livermore", R.drawable.abbott_henry_livermore);
        photoMap.put("abbott_joseph_carter", R.drawable.abbott_joseph_carter);
        photoMap.put("abercrombie_john_joseph", R.drawable.abercrombie_john_joseph);
        photoMap.put("adams_john", R.drawable.adams_john);
        photoMap.put("adams_william_wirt", R.drawable.adams_william_wirt);
        photoMap.put("albright_charles", R.drawable.albright_charles);
        photoMap.put("alexander_edward_porter", R.drawable.alexander_edward_porter);
        photoMap.put("alger_russell_a", R.drawable.alger_russell_a);
        photoMap.put("allen_henry_watkins", R.drawable.allen_henry_watkins);
        photoMap.put("allen_robert", R.drawable.allen_robert);
        photoMap.put("alvord_benjamin", R.drawable.alvord_benjamin);
        photoMap.put("ames_adelbert", R.drawable.ames_adelbert);
        photoMap.put("ammen_jacob", R.drawable.ammen_jacob);
        photoMap.put("anderson_george_t", R.drawable.anderson_george_t);
        photoMap.put("anderson_james_patton", R.drawable.anderson_james_patton);
        photoMap.put("anderson_joseph_r", R.drawable.anderson_joseph_r);
        photoMap.put("anderson_richard_h", R.drawable.anderson_richard_h);
        photoMap.put("anderson_robert", R.drawable.anderson_robert);
        photoMap.put("anderson_william_b", R.drawable.anderson_william_b);
        photoMap.put("andrews_christopher_columbus", R.drawable.andrews_christopher_columbus);
        photoMap.put("andrews_george_leonard", R.drawable.andrews_george_leonard);
        photoMap.put("archer_james_j", R.drawable.archer_james_j);
        photoMap.put("armistead_lewis", R.drawable.armistead_lewis);
        photoMap.put("armstrong_frank_crawford", R.drawable.armstrong_frank_crawford);
        photoMap.put("arnold_richard", R.drawable.arnold_richard);
        photoMap.put("asboth_alexander", R.drawable.asboth_alexander);
        photoMap.put("ashby_turner", R.drawable.ashby_turner);
        photoMap.put("augur_christopher_c", R.drawable.augur_christopher_c);
        photoMap.put("averell_william_w", R.drawable.averell_william_w);
        photoMap.put("averill_john_t", R.drawable.averill_john_t);
        photoMap.put("ayres_romeyn_b", R.drawable.ayres_romeyn_b);
        photoMap.put("babcock_orville_e", R.drawable.babcock_orville_e);
        photoMap.put("bailey_joseph", R.drawable.bailey_joseph);
        photoMap.put("baird_absalom", R.drawable.baird_absalom);
        photoMap.put("baker_alpheus", R.drawable.baker_alpheus);
        photoMap.put("baker_edward_dickinson", R.drawable.baker_edward_dickinson);
        photoMap.put("baker_lafayette_c", R.drawable.baker_lafayette_c);
        photoMap.put("baker_laurence_s", R.drawable.baker_laurence_s);
        photoMap.put("baldwin_william_edwin", R.drawable.baldwin_william_edwin);
        photoMap.put("banks_nathaniel_p", R.drawable.banks_nathaniel_p);
        photoMap.put("banning_henry_b", R.drawable.banning_henry_b);
        photoMap.put("barksdale_william", R.drawable.barksdale_william);
        photoMap.put("barlow_francis_c", R.drawable.barlow_francis_c);
        photoMap.put("barnard_john_g", R.drawable.barnard_john_g);
        photoMap.put("barnes_joseph", R.drawable.barnes_joseph);
        photoMap.put("barnum_henry_a", R.drawable.barnum_henry_a);
        photoMap.put("barringer_rufus", R.drawable.barringer_rufus);
        photoMap.put("barry_henry_w", R.drawable.barry_henry_w);
        photoMap.put("barry_john_d", R.drawable.barry_john_d);
        photoMap.put("barry_william_farquhar", R.drawable.barry_william_farquhar);
        photoMap.put("bartlett_joseph_j", R.drawable.bartlett_joseph_j);
        photoMap.put("bartlett_william_francis", R.drawable.bartlett_william_francis);
        photoMap.put("barton_seth", R.drawable.barton_seth);
        photoMap.put("batchelder_richard_napoleon", R.drawable.batchelder_richard_napoleon);
        photoMap.put("bates_delavan", R.drawable.bates_delavan);
        photoMap.put("bate_william_b", R.drawable.bate_william_b);
        photoMap.put("battle_cullen_a", R.drawable.battle_cullen_a);
        photoMap.put("baxter_henry", R.drawable.baxter_henry);
        photoMap.put("bayard_george_dashiell", R.drawable.bayard_george_dashiell);
        photoMap.put("beal_george_lafayette", R.drawable.beal_george_lafayette);
        photoMap.put("beall_william", R.drawable.beall_william);
        photoMap.put("beatty_john", R.drawable.beatty_john);
        photoMap.put("beatty_samuel", R.drawable.beatty_samuel);
        photoMap.put("beauregard_p_g_t", R.drawable.beauregard_p_g_t);
        photoMap.put("beaver_james_a", R.drawable.beaver_james_a);
        photoMap.put("bee_hamilton_p", R.drawable.bee_hamilton_p);
        photoMap.put("bell_tyree_h", R.drawable.bell_tyree_h);
        photoMap.put("benham_henry_washington", R.drawable.benham_henry_washington);
        photoMap.put("bennett_thomas_w", R.drawable.bennett_thomas_w);
        photoMap.put("benton_william_plummer", R.drawable.benton_william_plummer);
        photoMap.put("berry_hiram_gregory", R.drawable.berry_hiram_gregory);
        photoMap.put("beveridge_john_lourie", R.drawable.beveridge_john_lourie);
        photoMap.put("bidwell_daniel_d", R.drawable.bidwell_daniel_d);
        photoMap.put("bingham_henry_h", R.drawable.bingham_henry_h);
        photoMap.put("birge_henry_warner", R.drawable.birge_henry_warner);
        photoMap.put("birney_david_b", R.drawable.birney_david_b);
        photoMap.put("birney_william", R.drawable.birney_william);
        photoMap.put("black_john_c", R.drawable.black_john_c);
        photoMap.put("blair_jr_francis_preston", R.drawable.blair_jr_francis_preston);
        photoMap.put("blaisdell_william_e", R.drawable.blaisdell_william_e);
        photoMap.put("blenker_louis", R.drawable.blenker_louis);
        photoMap.put("blunt_james_g", R.drawable.blunt_james_g);
        photoMap.put("bohlen_henry", R.drawable.bohlen_henry);
        photoMap.put("bonham_milledge_luke", R.drawable.bonham_milledge_luke);
        photoMap.put("bose_dudley_m_du", R.drawable.bose_dudley_m_du);
        photoMap.put("bowen_james", R.drawable.bowen_james);
        photoMap.put("bowen_john_s", R.drawable.bowen_john_s);
        photoMap.put("bowen_thomas_m", R.drawable.bowen_thomas_m);
        photoMap.put("boyle_jeremiah", R.drawable.boyle_jeremiah);
        photoMap.put("boynton_henry_v", R.drawable.boynton_henry_v);
        photoMap.put("bragg_braxton", R.drawable.bragg_braxton);
        photoMap.put("bragg_edward_s", R.drawable.bragg_edward_s);
        photoMap.put("brandon_william_l", R.drawable.brandon_william_l);
        photoMap.put("brannan_john_milton", R.drawable.brannan_john_milton);
        photoMap.put("brayman_mason", R.drawable.brayman_mason);
        photoMap.put("breckinridge_john_c", R.drawable.breckinridge_john_c);
        photoMap.put("brewerton_henry", R.drawable.brewerton_henry);
        photoMap.put("brice_benjamin", R.drawable.brice_benjamin);
        photoMap.put("briggs_henry_shaw", R.drawable.briggs_henry_shaw);
        photoMap.put("brooke_john_r", R.drawable.brooke_john_r);
        photoMap.put("brooks_william_t_h", R.drawable.brooks_william_t_h);
        photoMap.put("brown_charles_elwood", R.drawable.brown_charles_elwood);
        photoMap.put("brown_egbert_b", R.drawable.brown_egbert_b);
        photoMap.put("browne_thomas_m", R.drawable.browne_thomas_m);
        photoMap.put("browne_william_m", R.drawable.browne_william_m);
        photoMap.put("brown_john_c", R.drawable.brown_john_c);
        photoMap.put("bryan_goode", R.drawable.bryan_goode);
        photoMap.put("buchanan_robert_c", R.drawable.buchanan_robert_c);
        photoMap.put("buckingham_catharinus_p", R.drawable.buckingham_catharinus_p);
        photoMap.put("buckland_ralph_pomeroy", R.drawable.buckland_ralph_pomeroy);
        photoMap.put("buckner_simon_bolivar", R.drawable.buckner_simon_bolivar);
        photoMap.put("buell_don_carlos", R.drawable.buell_don_carlos);
        photoMap.put("buford_john", R.drawable.buford_john);
        photoMap.put("buford_napoleon_bonaparte", R.drawable.buford_napoleon_bonaparte);
        photoMap.put("burbridge_stephen_g", R.drawable.burbridge_stephen_g);
        photoMap.put("burnett_henry_lawrence", R.drawable.burnett_henry_lawrence);
        photoMap.put("burnham_hiram", R.drawable.burnham_hiram);
        photoMap.put("burnside_ambrose", R.drawable.burnside_ambrose);
        photoMap.put("burns_william_wallace", R.drawable.burns_william_wallace);
        photoMap.put("busey_samuel_t", R.drawable.busey_samuel_t);
        photoMap.put("bussey_cyrus", R.drawable.bussey_cyrus);
        photoMap.put("busteed_richard", R.drawable.busteed_richard);
        photoMap.put("butler_benjamin", R.drawable.butler_benjamin);
        photoMap.put("butterfield_daniel", R.drawable.butterfield_daniel);
        photoMap.put("cabell_william_lewis", R.drawable.cabell_william_lewis);
        photoMap.put("cadwalader_george", R.drawable.cadwalader_george);
        photoMap.put("caldwell_john_c", R.drawable.caldwell_john_c);
        photoMap.put("callis_john_benton", R.drawable.callis_john_benton);
        photoMap.put("cameron_robert_alexander", R.drawable.cameron_robert_alexander);
        photoMap.put("campbell_charles_thomas", R.drawable.campbell_charles_thomas);
        photoMap.put("campbell_jacob_miller", R.drawable.campbell_jacob_miller);
        photoMap.put("campbell_john_allen", R.drawable.campbell_john_allen);
        photoMap.put("campbell_william_b", R.drawable.campbell_william_b);
        photoMap.put("canby_edward", R.drawable.canby_edward);
        photoMap.put("capehart_henry", R.drawable.capehart_henry);
        photoMap.put("capers_ellison", R.drawable.capers_ellison);
        photoMap.put("carlin_william", R.drawable.carlin_william);
        photoMap.put("carr_eugene_asa", R.drawable.carr_eugene_asa);
        photoMap.put("carrington_henry_b", R.drawable.carrington_henry_b);
        photoMap.put("carr_joseph_bradford", R.drawable.carr_joseph_bradford);
        photoMap.put("carroll_samuel_s", R.drawable.carroll_samuel_s);
        photoMap.put("carroll_william_henry", R.drawable.carroll_william_henry);
        photoMap.put("carter_samuel_p", R.drawable.carter_samuel_p);
        photoMap.put("casey_silas", R.drawable.casey_silas);
        photoMap.put("catlin_isaac_s", R.drawable.catlin_isaac_s);
        photoMap.put("catterson_robert_francis", R.drawable.catterson_robert_francis);
        photoMap.put("chalmers_james_ronald", R.drawable.chalmers_james_ronald);
        photoMap.put("chamberlain_joshua", R.drawable.chamberlain_joshua);
        photoMap.put("chambers_alexander", R.drawable.chambers_alexander);
        photoMap.put("chambliss_john_r", R.drawable.chambliss_john_r);
        photoMap.put("chaplin_daniel", R.drawable.chaplin_daniel);
        photoMap.put("chapman_george_henry", R.drawable.chapman_george_henry);
        photoMap.put("cheatham_benjamin_f", R.drawable.cheatham_benjamin_f);
        photoMap.put("chesnutjr_james", R.drawable.chesnutjr_james);
        photoMap.put("chilton_robert_h", R.drawable.chilton_robert_h);
        photoMap.put("chipman_norton_p", R.drawable.chipman_norton_p);
        photoMap.put("chivington_john", R.drawable.chivington_john);
        photoMap.put("chrysler_morgan_henry", R.drawable.chrysler_morgan_henry);
        photoMap.put("churchill_sylvester", R.drawable.churchill_sylvester);
        photoMap.put("churchill_thomas_james", R.drawable.churchill_thomas_james);
        photoMap.put("clanton_james_holt", R.drawable.clanton_james_holt);
        photoMap.put("clark_charles", R.drawable.clark_charles);
        photoMap.put("clarkjr_john_bullock", R.drawable.clarkjr_john_bullock);
        photoMap.put("clark_william_thomas", R.drawable.clark_william_thomas);
        photoMap.put("clay_cassius_marcellus", R.drawable.clay_cassius_marcellus);
        photoMap.put("clay_cecil", R.drawable.clay_cecil);
        photoMap.put("clayton_henry_delamar", R.drawable.clayton_henry_delamar);
        photoMap.put("clayton_powell", R.drawable.clayton_powell);
        photoMap.put("cleburne_patrick", R.drawable.cleburne_patrick);
        photoMap.put("clendenin_david_ramsay", R.drawable.clendenin_david_ramsay);
        photoMap.put("cleve_horatio_p_van", R.drawable.cleve_horatio_p_van);
        photoMap.put("cobb_amasa", R.drawable.cobb_amasa);
        photoMap.put("cobb_howell", R.drawable.cobb_howell);
        photoMap.put("cobham_jr_george_a", R.drawable.cobham_jr_george_a);
        photoMap.put("coburn_john", R.drawable.coburn_john);
        photoMap.put("cochrane_john", R.drawable.cochrane_john);
        photoMap.put("cocke_philip_st_george", R.drawable.cocke_philip_st_george);
        photoMap.put("cockrell_francis", R.drawable.cockrell_francis);
        photoMap.put("cogswell_william", R.drawable.cogswell_william);
        photoMap.put("collis_charles_h_t", R.drawable.collis_charles_h_t);
        photoMap.put("comly_james_m", R.drawable.comly_james_m);
        photoMap.put("conner_james", R.drawable.conner_james);
        photoMap.put("connor_patrick_edward", R.drawable.connor_patrick_edward);
        photoMap.put("connor_seldon", R.drawable.connor_seldon);
        photoMap.put("cooke_john_rogers", R.drawable.cooke_john_rogers);
        photoMap.put("cooke_philip_st_george", R.drawable.cooke_philip_st_george);
        photoMap.put("cook_john_pope", R.drawable.cook_john_pope);
        photoMap.put("cooper_douglas_h", R.drawable.cooper_douglas_h);
        photoMap.put("cooper_james", R.drawable.cooper_james);
        photoMap.put("cooper_joseph_alexander", R.drawable.cooper_joseph_alexander);
        photoMap.put("cooper_samuel", R.drawable.cooper_samuel);
        photoMap.put("copeland_joseph_t", R.drawable.copeland_joseph_t);
        photoMap.put("corcoran_michael", R.drawable.corcoran_michael);
        photoMap.put("corse_john_m", R.drawable.corse_john_m);
        photoMap.put("corse_montgomery_dent", R.drawable.corse_montgomery_dent);
        photoMap.put("cosby_george_b", R.drawable.cosby_george_b);
        photoMap.put("couch_darius_n", R.drawable.couch_darius_n);
        photoMap.put("coughlin_john", R.drawable.coughlin_john);
        photoMap.put("cowdin_robert", R.drawable.cowdin_robert);
        photoMap.put("cox_jacob_dolson", R.drawable.cox_jacob_dolson);
        photoMap.put("crawford_samuel_j", R.drawable.crawford_samuel_j);
        photoMap.put("crawford_samuel_w", R.drawable.crawford_samuel_w);
        photoMap.put("crittenden_george_b", R.drawable.crittenden_george_b);
        photoMap.put("crittenden_thomas_leonidas", R.drawable.crittenden_thomas_leonidas);
        photoMap.put("crittenden_thomas_turpin", R.drawable.crittenden_thomas_turpin);
        photoMap.put("crocker_marcellus_m", R.drawable.crocker_marcellus_m);
        photoMap.put("crook_george", R.drawable.crook_george);
        photoMap.put("croxton_john_t", R.drawable.croxton_john_t);
        photoMap.put("cruft_charles", R.drawable.cruft_charles);
        photoMap.put("cullum_george_washington", R.drawable.cullum_george_washington);
        photoMap.put("cumming_alfred", R.drawable.cumming_alfred);
        photoMap.put("cummings_alexander", R.drawable.cummings_alexander);
        photoMap.put("curtis_newton_martin", R.drawable.curtis_newton_martin);
        photoMap.put("curtis_samuel_ryan", R.drawable.curtis_samuel_ryan);
        photoMap.put("custer_george_armstrong", R.drawable.custer_george_armstrong);
        photoMap.put("cutcheon_byron_m", R.drawable.cutcheon_byron_m);
        photoMap.put("cutler_lysander", R.drawable.cutler_lysander);
        photoMap.put("daggett_aaron_s", R.drawable.daggett_aaron_s);
        photoMap.put("dana_napoleon_jt", R.drawable.dana_napoleon_jt);
        photoMap.put("davidson_henry_brevard", R.drawable.davidson_henry_brevard);
        photoMap.put("davidson_john", R.drawable.davidson_john);
        photoMap.put("davies_henry_eugene", R.drawable.davies_henry_eugene);
        photoMap.put("davis_edmund_j", R.drawable.davis_edmund_j);
        photoMap.put("davis_jefferson_c", R.drawable.davis_jefferson_c);
        photoMap.put("davis_joseph_r", R.drawable.davis_joseph_r);
        photoMap.put("dawes_rufus", R.drawable.dawes_rufus);
        photoMap.put("dearing_james", R.drawable.dearing_james);
        photoMap.put("deitzler_george", R.drawable.deitzler_george);
        photoMap.put("delafield_richard", R.drawable.delafield_richard);
        photoMap.put("dennis_elias_smith", R.drawable.dennis_elias_smith);
        photoMap.put("dent_frederick_tracy", R.drawable.dent_frederick_tracy);
        photoMap.put("denver_james_w", R.drawable.denver_james_w);
        photoMap.put("derveer_ferdinand_van", R.drawable.derveer_ferdinand_van);
        photoMap.put("deshler_james", R.drawable.deshler_james);
        photoMap.put("devens_charles", R.drawable.devens_charles);
        photoMap.put("devin_thomas", R.drawable.devin_thomas);
        photoMap.put("deweese_john_t", R.drawable.deweese_john_t);
        photoMap.put("dewey_joel", R.drawable.dewey_joel);
        photoMap.put("diven_alexander_s", R.drawable.diven_alexander_s);
        photoMap.put("dix_john_adams", R.drawable.dix_john_adams);
        photoMap.put("dodge_charles_c", R.drawable.dodge_charles_c);
        photoMap.put("dodge_grenville_m", R.drawable.dodge_grenville_m);
        photoMap.put("doolittle_charles", R.drawable.doolittle_charles);
        photoMap.put("dorn_earl_van", R.drawable.dorn_earl_van);
        photoMap.put("doubleday_abner", R.drawable.doubleday_abner);
        photoMap.put("dow_neal_s", R.drawable.dow_neal_s);
        photoMap.put("drake_francis_m", R.drawable.drake_francis_m);
        photoMap.put("drayton_thomas", R.drawable.drayton_thomas);
        photoMap.put("duffie_alfred_n", R.drawable.duffie_alfred_n);
        photoMap.put("duke_basil_w", R.drawable.duke_basil_w);
        photoMap.put("dumont_ebenezer", R.drawable.dumont_ebenezer);
        photoMap.put("dunn_william_m", R.drawable.dunn_william_m);
        photoMap.put("dunovant_john", R.drawable.dunovant_john);
        photoMap.put("duryee_abram", R.drawable.duryee_abram);
        photoMap.put("duval_isaac_h", R.drawable.duval_isaac_h);
        photoMap.put("dwight_william", R.drawable.dwight_william);
        photoMap.put("dyer_alexander_brydie", R.drawable.dyer_alexander_brydie);
        photoMap.put("eaton_amos_beebe", R.drawable.eaton_amos_beebe);
        photoMap.put("echols_john", R.drawable.echols_john);
        photoMap.put("ector_mathew", R.drawable.ector_mathew);
        photoMap.put("edgerton_alonzo_j", R.drawable.edgerton_alonzo_j);
        photoMap.put("edwards_john", R.drawable.edwards_john);
        photoMap.put("edwards_oliver", R.drawable.edwards_oliver);
        photoMap.put("egan_thomas_w", R.drawable.egan_thomas_w);
        photoMap.put("ekin_james_a", R.drawable.ekin_james_a);
        photoMap.put("ellet_alfred_w", R.drawable.ellet_alfred_w);
        photoMap.put("elzey_arnold", R.drawable.elzey_arnold);
        photoMap.put("emory_william_h", R.drawable.emory_william_h);
        photoMap.put("enochs_william_h", R.drawable.enochs_william_h);
        photoMap.put("eustis_henry_l", R.drawable.eustis_henry_l);
        photoMap.put("evans_clement_a", R.drawable.evans_clement_a);
        photoMap.put("ewell_richard_s", R.drawable.ewell_richard_s);
        photoMap.put("ewing_charles", R.drawable.ewing_charles);
        photoMap.put("ewing_hugh_boyle", R.drawable.ewing_hugh_boyle);
        photoMap.put("ewing_jr_thomas", R.drawable.ewing_jr_thomas);
        photoMap.put("fairchild_lucius", R.drawable.fairchild_lucius);
        photoMap.put("farnsworth_elon_j", R.drawable.farnsworth_elon_j);
        photoMap.put("farnsworth_john_f", R.drawable.farnsworth_john_f);
        photoMap.put("ferguson_samuel_w", R.drawable.ferguson_samuel_w);
        photoMap.put("ferrero_edward", R.drawable.ferrero_edward);
        photoMap.put("ferry_orris_s", R.drawable.ferry_orris_s);
        photoMap.put("fessenden_francis", R.drawable.fessenden_francis);
        photoMap.put("fessenden_james_deering", R.drawable.fessenden_james_deering);
        photoMap.put("field_charles_w", R.drawable.field_charles_w);
        photoMap.put("finley_clement", R.drawable.finley_clement);
        photoMap.put("finley_jesse_j", R.drawable.finley_jesse_j);
        photoMap.put("finnegan_joseph", R.drawable.finnegan_joseph);
        photoMap.put("fisk_clinton_b", R.drawable.fisk_clinton_b);
        photoMap.put("fletcher_thomas_clement", R.drawable.fletcher_thomas_clement);
        photoMap.put("floyd_john_b", R.drawable.floyd_john_b);
        photoMap.put("force_manning", R.drawable.force_manning);
        photoMap.put("forney_john_horace", R.drawable.forney_john_horace);
        photoMap.put("forney_william_h", R.drawable.forney_william_h);
        photoMap.put("forrest_nathan_bedford", R.drawable.forrest_nathan_bedford);
        photoMap.put("forsyth_james_w", R.drawable.forsyth_james_w);
        photoMap.put("foster_john_g", R.drawable.foster_john_g);
        photoMap.put("foster_robert_sanford", R.drawable.foster_robert_sanford);
        photoMap.put("franchot_richard", R.drawable.franchot_richard);
        photoMap.put("franklin_william_b", R.drawable.franklin_william_b);
        photoMap.put("frazer_john_w", R.drawable.frazer_john_w);
        photoMap.put("french_samuel_gibbs", R.drawable.french_samuel_gibbs);
        photoMap.put("french_william_h", R.drawable.french_william_h);
        photoMap.put("frost_daniel_m", R.drawable.frost_daniel_m);
        photoMap.put("fry_birkett_d", R.drawable.fry_birkett_d);
        photoMap.put("fry_james_barnet", R.drawable.fry_james_barnet);
        photoMap.put("fry_speed_s", R.drawable.fry_speed_s);
        photoMap.put("fuller_john_w", R.drawable.fuller_john_w);
        photoMap.put("gano_richard_montgomery", R.drawable.gano_richard_montgomery);
        photoMap.put("gardiner_alexander", R.drawable.gardiner_alexander);
        photoMap.put("gardner_franklin", R.drawable.gardner_franklin);
        photoMap.put("garfield_james_a", R.drawable.garfield_james_a);
        photoMap.put("garlandjr_samuel", R.drawable.garlandjr_samuel);
        photoMap.put("garnett_richard_b", R.drawable.garnett_richard_b);
        photoMap.put("garnett_robert_s", R.drawable.garnett_robert_s);
        photoMap.put("garrard_kenner", R.drawable.garrard_kenner);
        photoMap.put("garrott_isham_warren", R.drawable.garrott_isham_warren);
        photoMap.put("gartrell_lucius_jeremiah", R.drawable.gartrell_lucius_jeremiah);
        photoMap.put("gary_martin_witherspoon", R.drawable.gary_martin_witherspoon);
        photoMap.put("geary_john_w", R.drawable.geary_john_w);
        photoMap.put("getty_george_w", R.drawable.getty_george_w);
        photoMap.put("gibbon_john", R.drawable.gibbon_john);
        photoMap.put("gibbs_alfred", R.drawable.gibbs_alfred);
        photoMap.put("gibson_randall_l", R.drawable.gibson_randall_l);
        photoMap.put("gilbert_charles_champion", R.drawable.gilbert_charles_champion);
        photoMap.put("gilbert_james_isham", R.drawable.gilbert_james_isham);
        photoMap.put("gillem_alvan_cullem", R.drawable.gillem_alvan_cullem);
        photoMap.put("gillmore_quincy_adams", R.drawable.gillmore_quincy_adams);
        photoMap.put("gilmer_jeremy_francis", R.drawable.gilmer_jeremy_francis);
        photoMap.put("gist_states_rights", R.drawable.gist_states_rights);
        photoMap.put("gobin_john_p_s", R.drawable.gobin_john_p_s);
        photoMap.put("godwin_archibald_c", R.drawable.godwin_archibald_c);
        photoMap.put("goggin_james_m", R.drawable.goggin_james_m);
        photoMap.put("gordon_george_henry", R.drawable.gordon_george_henry);
        photoMap.put("gordon_james_b", R.drawable.gordon_james_b);
        photoMap.put("gordon_john_brown", R.drawable.gordon_john_brown);
        photoMap.put("gorgas_josiah", R.drawable.gorgas_josiah);
        photoMap.put("gorman_willis_a", R.drawable.gorman_willis_a);
        photoMap.put("govan_daniel", R.drawable.govan_daniel);
        photoMap.put("graham_charles_k", R.drawable.graham_charles_k);
        photoMap.put("granbury_hiram_b", R.drawable.granbury_hiram_b);
        photoMap.put("granger_gordon", R.drawable.granger_gordon);
        photoMap.put("granger_robert_s", R.drawable.granger_robert_s);
        photoMap.put("grant_lewis_a", R.drawable.grant_lewis_a);
        photoMap.put("grant_ulysses_s", R.drawable.grant_ulysses_s);
        photoMap.put("grayson_john_b", R.drawable.grayson_john_b);
        photoMap.put("greene_george_s", R.drawable.greene_george_s);
        photoMap.put("greene_oliver_duff", R.drawable.greene_oliver_duff);
        photoMap.put("green_martin_e", R.drawable.green_martin_e);
        photoMap.put("green_thomas", R.drawable.green_thomas);
        photoMap.put("gregg_david_mcmurtrie", R.drawable.gregg_david_mcmurtrie);
        photoMap.put("gregg_john", R.drawable.gregg_john);
        photoMap.put("gregg_maxcy", R.drawable.gregg_maxcy);
        photoMap.put("gresham_walter_q", R.drawable.gresham_walter_q);
        photoMap.put("griffin_charles", R.drawable.griffin_charles);
        photoMap.put("griffin_simon_goodell", R.drawable.griffin_simon_goodell);
        photoMap.put("grose_william", R.drawable.grose_william);
        photoMap.put("grosvenor_charles_h", R.drawable.grosvenor_charles_h);
        photoMap.put("grover_cuvier", R.drawable.grover_cuvier);
        photoMap.put("hagood_johnson", R.drawable.hagood_johnson);
        photoMap.put("halleck_henry", R.drawable.halleck_henry);
        photoMap.put("hamblin_joseph_eldridge", R.drawable.hamblin_joseph_eldridge);
        photoMap.put("hamilton_andrew_jackson", R.drawable.hamilton_andrew_jackson);
        photoMap.put("hamilton_charles_smith", R.drawable.hamilton_charles_smith);
        photoMap.put("hamilton_schuyler", R.drawable.hamilton_schuyler);
        photoMap.put("hamlin_charles", R.drawable.hamlin_charles);
        photoMap.put("hamlin_cyrus", R.drawable.hamlin_cyrus);
        photoMap.put("hammond_william_alexander", R.drawable.hammond_william_alexander);
        photoMap.put("hancock_winfield_scott", R.drawable.hancock_winfield_scott);
        photoMap.put("hanson_roger", R.drawable.hanson_roger);
        photoMap.put("hardee_william_j", R.drawable.hardee_william_j);
        photoMap.put("hardie_james_allen", R.drawable.hardie_james_allen);
        photoMap.put("harding_abner_c", R.drawable.harding_abner_c);
        photoMap.put("hardin_martin_davis", R.drawable.hardin_martin_davis);
        photoMap.put("harker_charles_garrison", R.drawable.harker_charles_garrison);
        photoMap.put("harney_william_s", R.drawable.harney_william_s);
        photoMap.put("harriman_walter", R.drawable.harriman_walter);
        photoMap.put("harris_andrew_l", R.drawable.harris_andrew_l);
        photoMap.put("harrison_benjamin", R.drawable.harrison_benjamin);
        photoMap.put("harris_thomas_maley", R.drawable.harris_thomas_maley);
        photoMap.put("harrow_william", R.drawable.harrow_william);
        photoMap.put("hartranft_john_f", R.drawable.hartranft_john_f);
        photoMap.put("hartsuff_george_lucas", R.drawable.hartsuff_george_lucas);
        photoMap.put("hascall_milo_smith", R.drawable.hascall_milo_smith);
        photoMap.put("haskin_joseph_a", R.drawable.haskin_joseph_a);
        photoMap.put("hatch_edward", R.drawable.hatch_edward);
        photoMap.put("hatch_john_porter", R.drawable.hatch_john_porter);
        photoMap.put("hatton_robert_h", R.drawable.hatton_robert_h);
        photoMap.put("haupt_herman", R.drawable.haupt_herman);
        photoMap.put("hawkins_isaac_roberts", R.drawable.hawkins_isaac_roberts);
        photoMap.put("hawkins_john_parker", R.drawable.hawkins_john_parker);
        photoMap.put("hawley_joseph_roswell", R.drawable.hawley_joseph_roswell);
        photoMap.put("hawthorn_alexander_travis", R.drawable.hawthorn_alexander_travis);
        photoMap.put("hayes_philip_c", R.drawable.hayes_philip_c);
        photoMap.put("hayes_rutherford_b", R.drawable.hayes_rutherford_b);
        photoMap.put("haynie_isham_n", R.drawable.haynie_isham_n);
        photoMap.put("hays_alexander", R.drawable.hays_alexander);
        photoMap.put("hays_harry_t", R.drawable.hays_harry_t);
        photoMap.put("hays_william", R.drawable.hays_william);
        photoMap.put("hazen_william_babcock", R.drawable.hazen_william_babcock);
        photoMap.put("hebert_louis", R.drawable.hebert_louis);
        photoMap.put("hebert_paul_octave", R.drawable.hebert_paul_octave);
        photoMap.put("heckman_charles_adam", R.drawable.heckman_charles_adam);
        photoMap.put("heintzelman_samuel_p", R.drawable.heintzelman_samuel_p);
        photoMap.put("helm_benjamin_hardin", R.drawable.helm_benjamin_hardin);
        photoMap.put("henderson_thomas_j", R.drawable.henderson_thomas_j);
        photoMap.put("henry_guy_vernor", R.drawable.henry_guy_vernor);
        photoMap.put("henry_william_w", R.drawable.henry_william_w);
        photoMap.put("herron_francis_j", R.drawable.herron_francis_j);
        photoMap.put("heth_henry", R.drawable.heth_henry);
        photoMap.put("hill_daniel_harvey", R.drawable.hill_daniel_harvey);
        photoMap.put("hinks_edward_winslow", R.drawable.hinks_edward_winslow);
        photoMap.put("hitchcock_ethan_a", R.drawable.hitchcock_ethan_a);
        photoMap.put("hobart_harrison_carroll", R.drawable.hobart_harrison_carroll);
        photoMap.put("hobson_edward_h", R.drawable.hobson_edward_h);
        photoMap.put("hodge_george_baird", R.drawable.hodge_george_baird);
        photoMap.put("hoke_robert", R.drawable.hoke_robert);
        photoMap.put("holmes_theophilus_h", R.drawable.holmes_theophilus_h);
        photoMap.put("holt_joseph", R.drawable.holt_joseph);
        photoMap.put("hood_john_bell", R.drawable.hood_john_bell);
        photoMap.put("hooker_joseph", R.drawable.hooker_joseph);
        photoMap.put("hovey_alvin_peterson", R.drawable.hovey_alvin_peterson);
        photoMap.put("hovey_charles_edward", R.drawable.hovey_charles_edward);
        photoMap.put("howard_oliver_o", R.drawable.howard_oliver_o);
        photoMap.put("howe_albion_p", R.drawable.howe_albion_p);
        photoMap.put("howell_joshua_b", R.drawable.howell_joshua_b);
        photoMap.put("hoyt_henry_m", R.drawable.hoyt_henry_m);
        photoMap.put("hubbard_lucius_frederick", R.drawable.hubbard_lucius_frederick);
        photoMap.put("hubbard_thomas_hamlin", R.drawable.hubbard_thomas_hamlin);
        photoMap.put("huger_benjamin", R.drawable.huger_benjamin);
        photoMap.put("humes_william_yc", R.drawable.humes_william_yc);
        photoMap.put("humphreys_andrew_a", R.drawable.humphreys_andrew_a);
        photoMap.put("hunter_david", R.drawable.hunter_david);
        photoMap.put("hunter_morton_c", R.drawable.hunter_morton_c);
        photoMap.put("hunt_henry_jackson", R.drawable.hunt_henry_jackson);
        photoMap.put("hunton_eppa", R.drawable.hunton_eppa);
        photoMap.put("hurlbut_stephen_a", R.drawable.hurlbut_stephen_a);
        photoMap.put("hyde_thomas_w", R.drawable.hyde_thomas_w);
        photoMap.put("ii_abraham_buford", R.drawable.ii_abraham_buford);
        photoMap.put("iii_archibald_gracie", R.drawable.iii_archibald_gracie);
        photoMap.put("iii_john_jacob_astor", R.drawable.iii_john_jacob_astor);
        photoMap.put("iii_wade_hampton", R.drawable.iii_wade_hampton);
        photoMap.put("ingalls_rufus", R.drawable.ingalls_rufus);
        photoMap.put("irvine_william", R.drawable.irvine_william);
        photoMap.put("iversonjr_alfred", R.drawable.iversonjr_alfred);
        photoMap.put("jackson_henry_r", R.drawable.jackson_henry_r);
        photoMap.put("jackson_james_s", R.drawable.jackson_james_s);
        photoMap.put("jackson_john_k", R.drawable.jackson_john_k);
        photoMap.put("jackson_nathaniel_j", R.drawable.jackson_nathaniel_j);
        photoMap.put("jackson_william_hicks", R.drawable.jackson_william_hicks);
        photoMap.put("jameson_charles_davis", R.drawable.jameson_charles_davis);
        photoMap.put("jenkins_micah", R.drawable.jenkins_micah);
        photoMap.put("johnson_bradley_tyler", R.drawable.johnson_bradley_tyler);
        photoMap.put("johnson_edward", R.drawable.johnson_edward);
        photoMap.put("johnson_richard_w", R.drawable.johnson_richard_w);
        photoMap.put("johnston_albert_sidney", R.drawable.johnston_albert_sidney);
        photoMap.put("johnston_george_doherty", R.drawable.johnston_george_doherty);
        photoMap.put("johnston_joseph_e", R.drawable.johnston_joseph_e);
        photoMap.put("jones_david_rumph", R.drawable.jones_david_rumph);
        photoMap.put("jones_john_m", R.drawable.jones_john_m);
        photoMap.put("jones_john_r", R.drawable.jones_john_r);
        photoMap.put("jones_john_s", R.drawable.jones_john_s);
        photoMap.put("jones_sam", R.drawable.jones_sam);
        photoMap.put("jordan_thomas", R.drawable.jordan_thomas);
        photoMap.put("judah_henry_m", R.drawable.judah_henry_m);
        photoMap.put("kane_thomas_l", R.drawable.kane_thomas_l);
        photoMap.put("kautz_august", R.drawable.kautz_august);
        photoMap.put("keifer_j_warren", R.drawable.keifer_j_warren);
        photoMap.put("keim_william_high", R.drawable.keim_william_high);
        photoMap.put("kelley_benjamin_franklin", R.drawable.kelley_benjamin_franklin);
        photoMap.put("kemper_james_l", R.drawable.kemper_james_l);
        photoMap.put("kenly_john_reese", R.drawable.kenly_john_reese);
        photoMap.put("kennedy_john_doby", R.drawable.kennedy_john_doby);
        photoMap.put("kennedy_robert_p", R.drawable.kennedy_robert_p);
        photoMap.put("ketcham_john_h", R.drawable.ketcham_john_h);
        photoMap.put("ketchum_william_scott", R.drawable.ketchum_william_scott);
        photoMap.put("keyes_erasmus_d", R.drawable.keyes_erasmus_d);
        photoMap.put("kilpatrick_hugh_judson", R.drawable.kilpatrick_hugh_judson);
        photoMap.put("kimball_nathan", R.drawable.kimball_nathan);
        photoMap.put("king_rufus", R.drawable.king_rufus);
        photoMap.put("kirby_dennis_t", R.drawable.kirby_dennis_t);
        photoMap.put("kirby_edmund", R.drawable.kirby_edmund);
        photoMap.put("kirk_edward_n", R.drawable.kirk_edward_n);
        photoMap.put("kirkland_william_whedbee", R.drawable.kirkland_william_whedbee);
        photoMap.put("kitching_j_howard", R.drawable.kitching_j_howard);
        photoMap.put("knipe_joseph_f", R.drawable.knipe_joseph_f);
        photoMap.put("krzyzanowski_wlodzimierz", R.drawable.krzyzanowski_wlodzimierz);
        photoMap.put("lander_frederick_w", R.drawable.lander_frederick_w);
        photoMap.put("lane_james_henry", R.drawable.lane_james_henry);
        photoMap.put("lane_james_henry", R.drawable.lane_james_henry);
        photoMap.put("lane_walter_p", R.drawable.lane_walter_p);
        photoMap.put("latham_george_r", R.drawable.latham_george_r);
        photoMap.put("law_evander_m", R.drawable.law_evander_m);
        photoMap.put("lawler_michael_kelly", R.drawable.lawler_michael_kelly);
        photoMap.put("lawrence_albert_g", R.drawable.lawrence_albert_g);
        photoMap.put("lawton_alexander", R.drawable.lawton_alexander);
        photoMap.put("leadbetter_danville", R.drawable.leadbetter_danville);
        photoMap.put("ledlie_james_h", R.drawable.ledlie_james_h);
        photoMap.put("lee_albert_lindley", R.drawable.lee_albert_lindley);
        photoMap.put("lee_edwin_gray", R.drawable.lee_edwin_gray);
        photoMap.put("lee_fitzhugh", R.drawable.lee_fitzhugh);
        photoMap.put("lee_robert_e", R.drawable.lee_robert_e);
        photoMap.put("lee_stephen_d", R.drawable.lee_stephen_d);
        photoMap.put("leggett_mortimer_dormer", R.drawable.leggett_mortimer_dormer);
        photoMap.put("leventhorpe_collett", R.drawable.leventhorpe_collett);
        photoMap.put("lewis_joseph_horace", R.drawable.lewis_joseph_horace);
        photoMap.put("lightburn_joseph_andrew_jackson", R.drawable.lightburn_joseph_andrew_jackson);
        photoMap.put("lilley_robert_d", R.drawable.lilley_robert_d);
        photoMap.put("littlejohn_dewitt_clinton", R.drawable.littlejohn_dewitt_clinton);
        photoMap.put("little_lewis_henry", R.drawable.little_lewis_henry);
        photoMap.put("lockwood_henry_hayes", R.drawable.lockwood_henry_hayes);
        photoMap.put("logan_john_a", R.drawable.logan_john_a);
        photoMap.put("logan_thomas_m", R.drawable.logan_thomas_m);
        photoMap.put("lomax_lunsford_l", R.drawable.lomax_lunsford_l);
        photoMap.put("longstreet_james", R.drawable.longstreet_james);
        photoMap.put("loring_william_w", R.drawable.loring_william_w);
        photoMap.put("love_george_m", R.drawable.love_george_m);
        photoMap.put("lowell_charles_russell", R.drawable.lowell_charles_russell);
        photoMap.put("lowrey_mark_perrin", R.drawable.lowrey_mark_perrin);
        photoMap.put("lowry_robert", R.drawable.lowry_robert);
        photoMap.put("lyon_hylan_b", R.drawable.lyon_hylan_b);
        photoMap.put("lyon_nathaniel", R.drawable.lyon_nathaniel);
        photoMap.put("lytle_william_haines", R.drawable.lytle_william_haines);
        photoMap.put("macdougall_clinton_d", R.drawable.macdougall_clinton_d);
        photoMap.put("mackenzie_ranald_s", R.drawable.mackenzie_ranald_s);
        photoMap.put("magruder_john_b", R.drawable.magruder_john_b);
        photoMap.put("mahone_william", R.drawable.mahone_william);
        photoMap.put("major_james_patrick", R.drawable.major_james_patrick);
        photoMap.put("maltby_jasper_a", R.drawable.maltby_jasper_a);
        photoMap.put("manderson_charles_f", R.drawable.manderson_charles_f);
        photoMap.put("maney_george", R.drawable.maney_george);
        photoMap.put("mansfield_joseph_k", R.drawable.mansfield_joseph_k);
        photoMap.put("manson_mahlon_dickerson", R.drawable.manson_mahlon_dickerson);
        photoMap.put("marcy_randolph_b", R.drawable.marcy_randolph_b);
        photoMap.put("marshall_humphrey", R.drawable.marshall_humphrey);
        photoMap.put("marston_gilman", R.drawable.marston_gilman);
        photoMap.put("martindale_john_h", R.drawable.martindale_john_h);
        photoMap.put("martin_james_green", R.drawable.martin_james_green);
        photoMap.put("martin_james_stewart", R.drawable.martin_james_stewart);
        photoMap.put("martin_john", R.drawable.martin_john);
        photoMap.put("martin_william_t", R.drawable.martin_william_t);
        photoMap.put("mason_john_s", R.drawable.mason_john_s);
        photoMap.put("maury_dabney_h", R.drawable.maury_dabney_h);
        photoMap.put("maxey_samuel_b", R.drawable.maxey_samuel_b);
        photoMap.put("mcarthur_john", R.drawable.mcarthur_john);
        photoMap.put("mccall_george_a", R.drawable.mccall_george_a);
        photoMap.put("mccausland_john", R.drawable.mccausland_john);
        photoMap.put("mccleery_james", R.drawable.mccleery_james);
        photoMap.put("mcclellan_george_b", R.drawable.mcclellan_george_b);
        photoMap.put("mcclernand_john_alexander", R.drawable.mcclernand_john_alexander);
        photoMap.put("mccomb_william", R.drawable.mccomb_william);
        photoMap.put("mccook_alexander_mcdowell", R.drawable.mccook_alexander_mcdowell);
        photoMap.put("mccook_anson_g", R.drawable.mccook_anson_g);
        photoMap.put("mccook_edward_m", R.drawable.mccook_edward_m);
        photoMap.put("mccook_robert_latimer", R.drawable.mccook_robert_latimer);
        photoMap.put("mccown_john_p", R.drawable.mccown_john_p);
        photoMap.put("mcculloch_benjamin", R.drawable.mcculloch_benjamin);
        photoMap.put("mcculloch_henry_eustace", R.drawable.mcculloch_henry_eustace);
        photoMap.put("mcdowell_irvin", R.drawable.mcdowell_irvin);
        photoMap.put("mcginnis_george_francis", R.drawable.mcginnis_george_francis);
        photoMap.put("mcgowan_samuel", R.drawable.mcgowan_samuel);
        photoMap.put("mcintosh_james_m", R.drawable.mcintosh_james_m);
        photoMap.put("mcintosh_john_baillie", R.drawable.mcintosh_john_baillie);
        photoMap.put("mclaws_lafayette", R.drawable.mclaws_lafayette);
        photoMap.put("mclean_nathaniel", R.drawable.mclean_nathaniel);
        photoMap.put("mcmahon_martin_t", R.drawable.mcmahon_martin_t);
        photoMap.put("mcmillan_james_w", R.drawable.mcmillan_james_w);
        photoMap.put("mcneil_john", R.drawable.mcneil_john);
        photoMap.put("mcnulta_john", R.drawable.mcnulta_john);
        photoMap.put("mcpherson_james_b", R.drawable.mcpherson_james_b);
        photoMap.put("mcrae_dandridge", R.drawable.mcrae_dandridge);
        photoMap.put("meade_george", R.drawable.meade_george);
        photoMap.put("meagher_thomas_francis", R.drawable.meagher_thomas_francis);
        photoMap.put("meigs_montgomery_c", R.drawable.meigs_montgomery_c);
        photoMap.put("mercer_hugh_w", R.drawable.mercer_hugh_w);
        photoMap.put("meredith_solomon", R.drawable.meredith_solomon);
        photoMap.put("merritt_wesley", R.drawable.merritt_wesley);
        photoMap.put("miles_nelson_a", R.drawable.miles_nelson_a);
        photoMap.put("miller_john_franklin", R.drawable.miller_john_franklin);
        photoMap.put("miller_stephen", R.drawable.miller_stephen);
        photoMap.put("miller_william", R.drawable.miller_william);
        photoMap.put("milroy_robert_h", R.drawable.milroy_robert_h);
        photoMap.put("mitchell_john_g", R.drawable.mitchell_john_g);
        photoMap.put("mitchell_robert_byington", R.drawable.mitchell_robert_byington);
        photoMap.put("mitchel_ormsby_m", R.drawable.mitchel_ormsby_m);
        photoMap.put("moonlight_thomas", R.drawable.moonlight_thomas);
        photoMap.put("moore_jesse_hale", R.drawable.moore_jesse_hale);
        photoMap.put("moore_john_creed", R.drawable.moore_john_creed);
        photoMap.put("moore_marshall_f", R.drawable.moore_marshall_f);
        photoMap.put("morell_george_w", R.drawable.morell_george_w);
        photoMap.put("morgan_edwin_d", R.drawable.morgan_edwin_d);
        photoMap.put("morgan_george_w", R.drawable.morgan_george_w);
        photoMap.put("morgan_james_d", R.drawable.morgan_james_d);
        photoMap.put("morgan_john_hunt", R.drawable.morgan_john_hunt);
        photoMap.put("morgan_john_tyler", R.drawable.morgan_john_tyler);
        photoMap.put("morton_james_st_clair", R.drawable.morton_james_st_clair);
        photoMap.put("mott_gershom", R.drawable.mott_gershom);
        photoMap.put("mouton_alfred", R.drawable.mouton_alfred);
        photoMap.put("mower_joseph_a", R.drawable.mower_joseph_a);
        photoMap.put("mulholland_st_clair_augustine", R.drawable.mulholland_st_clair_augustine);
        photoMap.put("mulligan_james_a", R.drawable.mulligan_james_a);
        photoMap.put("murray_eli_houston", R.drawable.murray_eli_houston);
        photoMap.put("myer_albert_j", R.drawable.myer_albert_j);
        photoMap.put("naglee_henry_morris", R.drawable.naglee_henry_morris);
        photoMap.put("nagle_james", R.drawable.nagle_james);
        photoMap.put("negley_james_s", R.drawable.negley_james_s);
        photoMap.put("neill_thomas_h", R.drawable.neill_thomas_h);
        photoMap.put("nelson_william_bull", R.drawable.nelson_william_bull);
        photoMap.put("newberry_walter_c", R.drawable.newberry_walter_c);
        photoMap.put("nickerson_franklin_s", R.drawable.nickerson_franklin_s);
        photoMap.put("noble_john_willock", R.drawable.noble_john_willock);
        photoMap.put("noyes_edward_follansbee", R.drawable.noyes_edward_follansbee);
        photoMap.put("oglesby_richard_j", R.drawable.oglesby_richard_j);
        photoMap.put("oliver_john_morrison", R.drawable.oliver_john_morrison);
        photoMap.put("oliver_paul_ambrose", R.drawable.oliver_paul_ambrose);
        photoMap.put("opdycke_emerson", R.drawable.opdycke_emerson);
        photoMap.put("ord_edward", R.drawable.ord_edward);
        photoMap.put("orme_william_w", R.drawable.orme_william_w);
        photoMap.put("osborn_thomas_o", R.drawable.osborn_thomas_o);
        photoMap.put("osterhaus_peter_joseph", R.drawable.osterhaus_peter_joseph);
        photoMap.put("owen_joshua_t", R.drawable.owen_joshua_t);
        photoMap.put("page_richard_lucian", R.drawable.page_richard_lucian);
        photoMap.put("paine_charles_jackson", R.drawable.paine_charles_jackson);
        photoMap.put("paine_eleazer_a", R.drawable.paine_eleazer_a);
        photoMap.put("palmer_innis_n", R.drawable.palmer_innis_n);
        photoMap.put("palmer_john_m", R.drawable.palmer_john_m);
        photoMap.put("palmer_joseph_b", R.drawable.palmer_joseph_b);
        photoMap.put("palmer_william_jackson", R.drawable.palmer_william_jackson);
        photoMap.put("parke_john", R.drawable.parke_john);
        photoMap.put("parker_ely_s", R.drawable.parker_ely_s);
        photoMap.put("parsons_mosby", R.drawable.parsons_mosby);
        photoMap.put("patrick_marsena_r", R.drawable.patrick_marsena_r);
        photoMap.put("patterson_francis_e", R.drawable.patterson_francis_e);
        photoMap.put("patterson_robert", R.drawable.patterson_robert);
        photoMap.put("paxton_elisha_f", R.drawable.paxton_elisha_f);
        photoMap.put("payne_william_h_f", R.drawable.payne_william_h_f);
        photoMap.put("pearson_alfred_l", R.drawable.pearson_alfred_l);
        photoMap.put("peck_john_j", R.drawable.peck_john_j);
        photoMap.put("peck_william_r", R.drawable.peck_william_r);
        photoMap.put("pegram_john", R.drawable.pegram_john);
        photoMap.put("pemberton_john_c", R.drawable.pemberton_john_c);
        photoMap.put("pender_william_dorsey", R.drawable.pender_william_dorsey);
        photoMap.put("pendleton_william_n", R.drawable.pendleton_william_n);
        photoMap.put("pennypacker_galusha", R.drawable.pennypacker_galusha);
        photoMap.put("perrin_abner_monroe", R.drawable.perrin_abner_monroe);
        photoMap.put("perry_edward_a", R.drawable.perry_edward_a);
        photoMap.put("phelps_john_s", R.drawable.phelps_john_s);
        photoMap.put("phelps_john_w", R.drawable.phelps_john_w);
        photoMap.put("pickett_george", R.drawable.pickett_george);
        photoMap.put("pike_albert", R.drawable.pike_albert);
        photoMap.put("pile_william_a", R.drawable.pile_william_a);
        photoMap.put("pillow_gideon_johnson", R.drawable.pillow_gideon_johnson);
        photoMap.put("plaisted_harris_m", R.drawable.plaisted_harris_m);
        photoMap.put("pleasonton_alfred", R.drawable.pleasonton_alfred);
        photoMap.put("poe_orlando_metcalfe", R.drawable.poe_orlando_metcalfe);
        photoMap.put("polignac_camille_armand_jules_marie_prince_de", R.drawable.polignac_camille_armand_jules_marie_prince_de);
        photoMap.put("polk_leonidas", R.drawable.polk_leonidas);
        photoMap.put("polk_lucius_e", R.drawable.polk_lucius_e);
        photoMap.put("pope_john", R.drawable.pope_john);
        photoMap.put("porter_andrew", R.drawable.porter_andrew);
        photoMap.put("porter_fitz_john", R.drawable.porter_fitz_john);
        photoMap.put("porter_horace", R.drawable.porter_horace);
        photoMap.put("posey_carnot", R.drawable.posey_carnot);
        photoMap.put("potter_joseph_h", R.drawable.potter_joseph_h);
        photoMap.put("potter_robert_brown", R.drawable.potter_robert_brown);
        photoMap.put("potts_benjamin_f", R.drawable.potts_benjamin_f);
        photoMap.put("prentiss_benjamin", R.drawable.prentiss_benjamin);
        photoMap.put("preston_william", R.drawable.preston_william);
        photoMap.put("price_sterling", R.drawable.price_sterling);
        photoMap.put("pryor_roger_atkinson", R.drawable.pryor_roger_atkinson);
        photoMap.put("rains_gabriel_j", R.drawable.rains_gabriel_j);
        photoMap.put("rains_james_edwards", R.drawable.rains_james_edwards);
        photoMap.put("ramseur_stephen_dodson", R.drawable.ramseur_stephen_dodson);
        photoMap.put("randolph_george_w", R.drawable.randolph_george_w);
        photoMap.put("ransomjr_robert", R.drawable.ransomjr_robert);
        photoMap.put("ransom_matt_whitaker", R.drawable.ransom_matt_whitaker);
        photoMap.put("ransom_thomas_e_g", R.drawable.ransom_thomas_e_g);
        photoMap.put("raum_green_berry", R.drawable.raum_green_berry);
        photoMap.put("rawlins_john_aaron", R.drawable.rawlins_john_aaron);
        photoMap.put("reno_jesse_l", R.drawable.reno_jesse_l);
        photoMap.put("revere_joseph_warren", R.drawable.revere_joseph_warren);
        photoMap.put("reynolds_alexander_w", R.drawable.reynolds_alexander_w);
        photoMap.put("reynolds_john_f", R.drawable.reynolds_john_f);
        photoMap.put("reynolds_joseph_j", R.drawable.reynolds_joseph_j);
        photoMap.put("rice_americus_v", R.drawable.rice_americus_v);
        photoMap.put("rice_elliott_warren", R.drawable.rice_elliott_warren);
        photoMap.put("rice_james_clay", R.drawable.rice_james_clay);
        photoMap.put("rice_samuel_allen", R.drawable.rice_samuel_allen);
        photoMap.put("richardson_israel_b", R.drawable.richardson_israel_b);
        photoMap.put("ricketts_james_b", R.drawable.ricketts_james_b);
        photoMap.put("ripley_james_wolfe", R.drawable.ripley_james_wolfe);
        photoMap.put("ripley_roswell_s", R.drawable.ripley_roswell_s);
        photoMap.put("roane_john_selden", R.drawable.roane_john_selden);
        photoMap.put("roberts_benjamin_s", R.drawable.roberts_benjamin_s);
        photoMap.put("robertson_felix_huston", R.drawable.robertson_felix_huston);
        photoMap.put("roberts_william_paul", R.drawable.roberts_william_paul);
        photoMap.put("robinson_james_s", R.drawable.robinson_james_s);
        photoMap.put("robinson_john_c", R.drawable.robinson_john_c);
        photoMap.put("roddey_phillip", R.drawable.roddey_phillip);
        photoMap.put("rodes_robert_e", R.drawable.rodes_robert_e);
        photoMap.put("rodman_isaac_p", R.drawable.rodman_isaac_p);
        photoMap.put("rosecrans_william", R.drawable.rosecrans_william);
        photoMap.put("rosser_thomas_l", R.drawable.rosser_thomas_l);
        photoMap.put("ross_lawrence_sullivan", R.drawable.ross_lawrence_sullivan);
        photoMap.put("ross_leonard_fulton", R.drawable.ross_leonard_fulton);
        photoMap.put("rousseau_lovell", R.drawable.rousseau_lovell);
        photoMap.put("ruger_thomas_h", R.drawable.ruger_thomas_h);
        photoMap.put("ruggles_daniel", R.drawable.ruggles_daniel);
        photoMap.put("rusk_jeremiah_mclain", R.drawable.rusk_jeremiah_mclain);
        photoMap.put("russell_david_allen", R.drawable.russell_david_allen);
        photoMap.put("russy_gustavus_de", R.drawable.russy_gustavus_de);
        photoMap.put("salomon_frederick_c", R.drawable.salomon_frederick_c);
        photoMap.put("sanborn_john_b", R.drawable.sanborn_john_b);
        photoMap.put("sanders_william_p", R.drawable.sanders_william_p);
        photoMap.put("scales_alfred_moore", R.drawable.scales_alfred_moore);
        photoMap.put("scammon_eliakim_p", R.drawable.scammon_eliakim_p);
        photoMap.put("schenck_robert_c", R.drawable.schenck_robert_c);
        photoMap.put("schimmelfennig_alexander", R.drawable.schimmelfennig_alexander);
        photoMap.put("schoepf_albin_francisco", R.drawable.schoepf_albin_francisco);
        photoMap.put("schofield_john", R.drawable.schofield_john);
        photoMap.put("schurz_carl", R.drawable.schurz_carl);
        photoMap.put("scott_robert_kingston", R.drawable.scott_robert_kingston);
        photoMap.put("scott_winfield", R.drawable.scott_winfield);
        photoMap.put("scurry_william_read", R.drawable.scurry_william_read);
        photoMap.put("sears_claudius_w", R.drawable.sears_claudius_w);
        photoMap.put("sedgwick_john", R.drawable.sedgwick_john);
        photoMap.put("semmes_paul_jones", R.drawable.semmes_paul_jones);
        photoMap.put("seymour_truman", R.drawable.seymour_truman);
        photoMap.put("shackelford_james_m", R.drawable.shackelford_james_m);
        photoMap.put("shaffer_john", R.drawable.shaffer_john);
        photoMap.put("shafter_william_rufus", R.drawable.shafter_william_rufus);
        photoMap.put("shaler_alexander", R.drawable.shaler_alexander);
        photoMap.put("shanks_john_p_c", R.drawable.shanks_john_p_c);
        photoMap.put("shelby_joseph_o", R.drawable.shelby_joseph_o);
        photoMap.put("sheldon_lionel_allen", R.drawable.sheldon_lionel_allen);
        photoMap.put("shelley_charles_m", R.drawable.shelley_charles_m);
        photoMap.put("shepley_george_foster", R.drawable.shepley_george_foster);
        photoMap.put("sheridan_philip", R.drawable.sheridan_philip);
        photoMap.put("sherman_thomas_w", R.drawable.sherman_thomas_w);
        photoMap.put("sherman_william_tecumseh", R.drawable.sherman_william_tecumseh);
        photoMap.put("sherwood_isaac_r", R.drawable.sherwood_isaac_r);
        photoMap.put("shields_james", R.drawable.shields_james);
        photoMap.put("shoup_francis_a", R.drawable.shoup_francis_a);
        photoMap.put("sibley_henry_hastings", R.drawable.sibley_henry_hastings);
        photoMap.put("sibley_henry_hopkins", R.drawable.sibley_henry_hopkins);
        photoMap.put("sickles_daniel", R.drawable.sickles_daniel);
        photoMap.put("sigel_franz", R.drawable.sigel_franz);
        photoMap.put("sill_joshua_w", R.drawable.sill_joshua_w);
        photoMap.put("slack_william_y", R.drawable.slack_william_y);
        photoMap.put("slemmer_adam_j", R.drawable.slemmer_adam_j);
        photoMap.put("slocum_henry_warner", R.drawable.slocum_henry_warner);
        photoMap.put("slough_john_p", R.drawable.slough_john_p);
        photoMap.put("smith_andrew_jackson", R.drawable.smith_andrew_jackson);
        photoMap.put("smith_charles_ferguson", R.drawable.smith_charles_ferguson);
        photoMap.put("smith_edmund_kirby", R.drawable.smith_edmund_kirby);
        photoMap.put("smith_giles_alexander", R.drawable.smith_giles_alexander);
        photoMap.put("smith_green_clay", R.drawable.smith_green_clay);
        photoMap.put("smith_gustavus_woodson", R.drawable.smith_gustavus_woodson);
        photoMap.put("smith_james_argyle", R.drawable.smith_james_argyle);
        photoMap.put("smith_john_e", R.drawable.smith_john_e);
        photoMap.put("smith_martin_luther", R.drawable.smith_martin_luther);
        photoMap.put("smith_morgan_lewis", R.drawable.smith_morgan_lewis);
        photoMap.put("smith_preston", R.drawable.smith_preston);
        photoMap.put("smith_thomas_benton", R.drawable.smith_thomas_benton);
        photoMap.put("smith_thomas_c_h", R.drawable.smith_thomas_c_h);
        photoMap.put("smith_thomas_kilby", R.drawable.smith_thomas_kilby);
        photoMap.put("smith_william", R.drawable.smith_william);
        photoMap.put("smith_william_sooy", R.drawable.smith_william_sooy);
        photoMap.put("sorrel_moxley", R.drawable.sorrel_moxley);
        photoMap.put("spaulding_oliver_l", R.drawable.spaulding_oliver_l);
        photoMap.put("spears_james_g", R.drawable.spears_james_g);
        photoMap.put("spencer_george_e", R.drawable.spencer_george_e);
        photoMap.put("spinola_francis_b", R.drawable.spinola_francis_b);
        photoMap.put("sprague_john_w", R.drawable.sprague_john_w);
        photoMap.put("stahel_julius", R.drawable.stahel_julius);
        photoMap.put("stanley_david_s", R.drawable.stanley_david_s);
        photoMap.put("starke_william_e", R.drawable.starke_william_e);
        photoMap.put("starkweather_john_converse", R.drawable.starkweather_john_converse);
        photoMap.put("steedman_james_b", R.drawable.steedman_james_b);
        photoMap.put("steele_frederick", R.drawable.steele_frederick);
        photoMap.put("steele_william", R.drawable.steele_william);
        photoMap.put("steuart_george_h", R.drawable.steuart_george_h);
        photoMap.put("stevens_aaron_fletcher", R.drawable.stevens_aaron_fletcher);
        photoMap.put("stevens_hazard", R.drawable.stevens_hazard);
        photoMap.put("stevens_isaac", R.drawable.stevens_isaac);
        photoMap.put("stevens_walter_h", R.drawable.stevens_walter_h);
        photoMap.put("stokes_william_brickly", R.drawable.stokes_william_brickly);
        photoMap.put("stoneman_george", R.drawable.stoneman_george);
        photoMap.put("stone_william_m", R.drawable.stone_william_m);
        photoMap.put("stoughton_edwin_h", R.drawable.stoughton_edwin_h);
        photoMap.put("stovall_marcellus_augustus", R.drawable.stovall_marcellus_augustus);
        photoMap.put("strahl_otho_f", R.drawable.strahl_otho_f);
        photoMap.put("strong_george_crockett", R.drawable.strong_george_crockett);
        photoMap.put("sturgis_samuel_d", R.drawable.sturgis_samuel_d);
        photoMap.put("sully_alfred", R.drawable.sully_alfred);
        photoMap.put("sumner_edwin_vose", R.drawable.sumner_edwin_vose);
        photoMap.put("swayne_wager", R.drawable.swayne_wager);
        photoMap.put("sweeny_thomas_william", R.drawable.sweeny_thomas_william);
        photoMap.put("sykes_george", R.drawable.sykes_george);
        photoMap.put("sypher_j_hale", R.drawable.sypher_j_hale);
        photoMap.put("tappan_james_camp", R.drawable.tappan_james_camp);
        photoMap.put("taylor_george_w", R.drawable.taylor_george_w);
        photoMap.put("taylor_nelson", R.drawable.taylor_nelson);
        photoMap.put("taylor_richard", R.drawable.taylor_richard);
        photoMap.put("taylor_thomas_h", R.drawable.taylor_thomas_h);
        photoMap.put("terrill_james_b", R.drawable.terrill_james_b);
        photoMap.put("terrill_william_r", R.drawable.terrill_william_r);
        photoMap.put("terry_alfred", R.drawable.terry_alfred);
        photoMap.put("terry_william_r", R.drawable.terry_william_r);
        photoMap.put("thayer_john_milton", R.drawable.thayer_john_milton);
        photoMap.put("thayer_sylvanus", R.drawable.thayer_sylvanus);
        photoMap.put("thomas_bryan_m", R.drawable.thomas_bryan_m);
        photoMap.put("thomas_edward_lloyd", R.drawable.thomas_edward_lloyd);
        photoMap.put("thomas_george_henry", R.drawable.thomas_george_henry);
        photoMap.put("thomas_lorenzo", R.drawable.thomas_lorenzo);
        photoMap.put("thomas_stephen", R.drawable.thomas_stephen);
        photoMap.put("thompson_william", R.drawable.thompson_william);
        photoMap.put("thruston_charles_mynn", R.drawable.thruston_charles_mynn);
        photoMap.put("tilghman_lloyd", R.drawable.tilghman_lloyd);
        photoMap.put("todd_john_blair_smith", R.drawable.todd_john_blair_smith);
        photoMap.put("tompkins_charles_henry", R.drawable.tompkins_charles_henry);
        photoMap.put("toombs_robert", R.drawable.toombs_robert);
        photoMap.put("toon_thomas_f", R.drawable.toon_thomas_f);
        photoMap.put("torbert_alfred_thomas_archimedes", R.drawable.torbert_alfred_thomas_archimedes);
        photoMap.put("totten_joseph_gilbert", R.drawable.totten_joseph_gilbert);
        photoMap.put("tower_zealous_bates", R.drawable.tower_zealous_bates);
        photoMap.put("tracy_benjamin_f", R.drawable.tracy_benjamin_f);
        photoMap.put("tracy_edward_d", R.drawable.tracy_edward_d);
        photoMap.put("trapier_james_h", R.drawable.trapier_james_h);
        photoMap.put("tucker_william_f", R.drawable.tucker_william_f);
        photoMap.put("turchaninov_ivan", R.drawable.turchaninov_ivan);
        photoMap.put("tuttle_james_m", R.drawable.tuttle_james_m);
        photoMap.put("twiggs_david_e", R.drawable.twiggs_david_e);
        photoMap.put("tyler_daniel", R.drawable.tyler_daniel);
        photoMap.put("tyler_erastus_b", R.drawable.tyler_erastus_b);
        photoMap.put("tyler_robert_o", R.drawable.tyler_robert_o);
        photoMap.put("tyndale_hector", R.drawable.tyndale_hector);
        photoMap.put("ullman_daniel", R.drawable.ullman_daniel);
        photoMap.put("upton_emory", R.drawable.upton_emory);
        photoMap.put("vance_robert_b", R.drawable.vance_robert_b);
        photoMap.put("vandever_william", R.drawable.vandever_william);
        photoMap.put("vegesack_ernest_von", R.drawable.vegesack_ernest_von);
        photoMap.put("viele_egbert_ludovicus", R.drawable.viele_egbert_ludovicus);
        photoMap.put("vincent_strong", R.drawable.vincent_strong);
        photoMap.put("vliet_stewart_van", R.drawable.vliet_stewart_van);
        photoMap.put("vogdes_israel", R.drawable.vogdes_israel);
        photoMap.put("wadsworth_james_s", R.drawable.wadsworth_james_s);
        photoMap.put("wagner_george_d", R.drawable.wagner_george_d);
        photoMap.put("walker_james_a", R.drawable.walker_james_a);
        photoMap.put("walker_john_george", R.drawable.walker_john_george);
        photoMap.put("walker_leroy_pope", R.drawable.walker_leroy_pope);
        photoMap.put("walker_lucius_m", R.drawable.walker_lucius_m);
        photoMap.put("walker_reuben_lindsay", R.drawable.walker_reuben_lindsay);
        photoMap.put("walker_william_ht", R.drawable.walker_william_ht);
        photoMap.put("walker_william_stephen", R.drawable.walker_william_stephen);
        photoMap.put("wallace_lew", R.drawable.wallace_lew);
        photoMap.put("wallace_w_h_l", R.drawable.wallace_w_h_l);
        photoMap.put("wallace_william_henry", R.drawable.wallace_william_henry);
        photoMap.put("walthall_edward_c", R.drawable.walthall_edward_c);
        photoMap.put("ward_george_hull", R.drawable.ward_george_hull);
        photoMap.put("ward_j_h_hobart", R.drawable.ward_j_h_hobart);
        photoMap.put("warren_gouverneur_k", R.drawable.warren_gouverneur_k);
        photoMap.put("washburn_cadwallader_c", R.drawable.washburn_cadwallader_c);
        photoMap.put("waterhouse_richard", R.drawable.waterhouse_richard);
        photoMap.put("watie_stand", R.drawable.watie_stand);
        photoMap.put("wayne_henry_c", R.drawable.wayne_henry_c);
        photoMap.put("weaver_james_b", R.drawable.weaver_james_b);
        photoMap.put("webb_alexander_s", R.drawable.webb_alexander_s);
        photoMap.put("weed_stephen_h", R.drawable.weed_stephen_h);
        photoMap.put("weitzel_godfrey", R.drawable.weitzel_godfrey);
        photoMap.put("wells_henry_h", R.drawable.wells_henry_h);
        photoMap.put("welsh_thomas", R.drawable.welsh_thomas);
        photoMap.put("west_joseph_r", R.drawable.west_joseph_r);
        photoMap.put("wharton_gabriel_c", R.drawable.wharton_gabriel_c);
        photoMap.put("wharton_john_a", R.drawable.wharton_john_a);
        photoMap.put("wheaton_frank", R.drawable.wheaton_frank);
        photoMap.put("wheeler_joseph", R.drawable.wheeler_joseph);
        photoMap.put("whipple_amiel_weeks", R.drawable.whipple_amiel_weeks);
        photoMap.put("whitaker_walter_c", R.drawable.whitaker_walter_c);
        photoMap.put("white_harry", R.drawable.white_harry);
        photoMap.put("whitfield_john_wilkins", R.drawable.whitfield_john_wilkins);
        photoMap.put("wickham_williams_carter", R.drawable.wickham_williams_carter);
        photoMap.put("wigfall_louis", R.drawable.wigfall_louis);
        photoMap.put("wilcox_cadmus_m", R.drawable.wilcox_cadmus_m);
        photoMap.put("wild_edward_a", R.drawable.wild_edward_a);
        photoMap.put("willcox_orlando_b", R.drawable.willcox_orlando_b);
        photoMap.put("williams_alpheus_s", R.drawable.williams_alpheus_s);
        photoMap.put("williams_john_stuart", R.drawable.williams_john_stuart);
        photoMap.put("williamson_james_alexander", R.drawable.williamson_james_alexander);
        photoMap.put("williams_seth", R.drawable.williams_seth);
        photoMap.put("willich_august", R.drawable.willich_august);
        photoMap.put("winder_charles_sidney", R.drawable.winder_charles_sidney);
        photoMap.put("winder_john_h", R.drawable.winder_john_h);
        photoMap.put("wise_henry_a", R.drawable.wise_henry_a);
        photoMap.put("withers_jones_m", R.drawable.withers_jones_m);
        photoMap.put("wofford_william_t", R.drawable.wofford_william_t);
        photoMap.put("woodbury_daniel_phineas", R.drawable.woodbury_daniel_phineas);
        photoMap.put("woodford_stewart_l", R.drawable.woodford_stewart_l);
        photoMap.put("wood_s_a_m", R.drawable.wood_s_a_m);
        photoMap.put("wood_thomas_j", R.drawable.wood_thomas_j);
        photoMap.put("wool_john_e", R.drawable.wool_john_e);
        photoMap.put("wright_ambrose_r", R.drawable.wright_ambrose_r);
        photoMap.put("wright_horatio", R.drawable.wright_horatio);
        photoMap.put("wright_marcus_joseph", R.drawable.wright_marcus_joseph);
        photoMap.put("york_zebulon", R.drawable.york_zebulon);
        photoMap.put("young_samuel_baldwin_marks", R.drawable.young_samuel_baldwin_marks);
        photoMap.put("young_thomas_l", R.drawable.young_thomas_l);
        photoMap.put("zook_samuel_k", R.drawable.zook_samuel_k);
        photoMap.put("union", R.drawable.union);
        photoMap.put("confederate", R.drawable.confederate);

        setContentView(R.layout.activity_civilwargenerals);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_civilwargenerals, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void CopyDB(InputStream inputStream, OutputStream outputStream)
            throws IOException {
        // copy 1K bytes of file at a time
        //Log.w(TAG, "In Fighterjets.CopyDB()");
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }

    public void onClickUnion(View view) {
        com.jimsuplee.civilwargenerals.Civilwargenerals.carrierSearchList.clear();
        Intent iGeneral = new Intent("com.jimsuplee.civilwargenerals.General");
        Civilwargenerals.army="union";
        startActivityForResult(iGeneral,0);
    }

    public void onClickConfederate(View view) {
        com.jimsuplee.civilwargenerals.Civilwargenerals.carrierSearchList.clear();
        Intent iGeneral = new Intent("com.jimsuplee.civilwargenerals.General");
        Civilwargenerals.army="confederate";
        startActivityForResult(iGeneral,0);
    }

    public void onClickAll(View view) {
        com.jimsuplee.civilwargenerals.Civilwargenerals.carrierSearchList.clear();
        Intent iGeneral = new Intent("com.jimsuplee.civilwargenerals.General");
        Civilwargenerals.army="all";
        startActivityForResult(iGeneral,0);
    }

    public void onClickInfo(View view) {
        com.jimsuplee.civilwargenerals.Civilwargenerals.carrierSearchList.clear();
        TextView tv = (TextView) findViewById(R.id.txt_general);
        tv.setText(R.string.info);
        ImageView iv = (ImageView) findViewById(R.id.imagedetail);
        iv.setImageResource(R.drawable.civilwar);
        Toast.makeText(this, "Scroll down for help", Toast.LENGTH_LONG).show();
    }
    public void onClickPictures(View view) {
        Intent iPictures = new Intent("com.jimsuplee.civilwargenerals.Pictures");
        Civilwargenerals.army="all";
        //we can reuse the '0' activity because Pictures will behave same as General, it will
        // return the general chosen
        startActivityForResult(iPictures, 0);
    }

    public void onClickSearch(View view) {
        com.jimsuplee.civilwargenerals.Civilwargenerals.carrierSearchList.clear();
        EditText txt_carriersearch = (EditText) findViewById(R.id.txt_carriersearch);
        String carrierdataParam = txt_carriersearch.getText().toString();
        EditText txt_carriersearchtwo = (EditText) findViewById(R.id.txt_carriersearchtwo);
        String carrierdataParamtwo = txt_carriersearchtwo.getText().toString();
        EditText txt_carriersearchthree = (EditText) findViewById(R.id.txt_carriersearchthree);
        String carrierdataParamthree = txt_carriersearchthree.getText().toString();
        carrierdataParam = "%"+carrierdataParam+"%";
        db.open();
        Cursor c;
        if(carrierdataParam.length()!=0 && carrierdataParamtwo.length()!=0 && carrierdataParamthree.
                length()!=0) {
            carrierdataParam ="%"+carrierdataParam+"%";
            carrierdataParamtwo ="%"+carrierdataParamtwo+"%";
            carrierdataParamthree ="%"+carrierdataParamthree+"%";
            c = db.getByCarrierdata(carrierdataParam,carrierdataParamtwo, carrierdataParamthree)
            ;
        }else if(carrierdataParam.length()!=0 && carrierdataParamtwo.length()!=0 && carrierdataParamthree.length()==0) {
            carrierdataParam ="%"+carrierdataParam+"%";
            carrierdataParamtwo ="%"+carrierdataParamtwo+"%";
            c = db.getByCarrierdata(carrierdataParam,carrierdataParamtwo);
        }else if(carrierdataParam.length()!=0 && carrierdataParamtwo.length()==0 && carrierdataParamthree.length()==0) {
            carrierdataParam ="%"+carrierdataParam+"%";
            c = db.getByCarrierdata(carrierdataParam);
        }else if(carrierdataParam.length()==0 && carrierdataParamtwo.length()!=0 && carrierdataParamthree.length()!=0) {
            carrierdataParamtwo ="%"+carrierdataParamtwo+"%";
            carrierdataParamthree ="%"+carrierdataParamthree+"%";
            c = db.getByCarrierdata(carrierdataParamtwo, carrierdataParamthree);
        }else if(carrierdataParam.length()==0 && carrierdataParamtwo.length()==0 && carrierdataParamthree.length()!=0) {
            carrierdataParamthree ="%"+carrierdataParamthree+"%";
            c = db.getByCarrierdata(carrierdataParamthree);
        }else if(carrierdataParam.length()!=0 && carrierdataParamtwo.length()==0 && carrierdataParamthree.length()!=0) {
            carrierdataParam ="%"+carrierdataParam+"%";
            carrierdataParamthree ="%"+carrierdataParamthree+"%";
            c = db.getByCarrierdata(carrierdataParam, carrierdataParamthree);
        }else if(carrierdataParam.length()==0 && carrierdataParamtwo.length()!=0 && carrierdataParamthree.length()==0) {
            carrierdataParamtwo ="%"+carrierdataParamtwo+"%";
            c = db.getByCarrierdata(carrierdataParamtwo);
        } else {
            //should never get here!
            //Log.w(TAG, "In Civilwargenerals.onClickSearch(), BAD SHOULD NEVER GET HERE");
            carrierdataParam ="%madison%";
            c = db.getByCarrierdata(carrierdataParam);
        }
        //Log.w(TAG, "In Civilwargenerals.onClickSearch(), about to db.close()");
        db.close();
        //Log.w(TAG, "In Civilwargenerals.onClickSearch(), Got cursor from db.getByLyric("+carrierdataParam+"), now loop");
        if (c != null) {
            //Log.w(TAG, "In Civilwargenerals.onClickSearchs(), cursor c is not null.");
        }
        //Log.w(TAG, "In Civilwargenerals.onClickSearchs(), about to c.moveToFirst()");
        if (c.moveToFirst()) {
            //Log.w(TAG, "In Civilwargenerals.onClickSearchs(), c.moveToFirst() returned true");
            do {
                //results +=  "RESULTS: "+c.getString(0) ;
                //results += c.getString(0)+"\n";
                com.jimsuplee.civilwargenerals.Civilwargenerals.carrierSearchList.add(c.getString(0));
            } while (c.moveToNext());
        }else {
            //Log.w(TAG, "In Civilwargenerals.onClickSearchs(), c.moveToFirst() returned
            //NOT TRUE");
            //This is not good but is returned if there are no results.  This has the good effect
            // of making sure the user has SOMETHING to click, and also gives them the information
            // for the general_brigadier listing which probably shouldn't be in the database in the
            // first place but is an artifact of automation during db construction.  We should
            // also Toast them about the "no results matched your query".
            com.jimsuplee.civilwargenerals.Civilwargenerals.carrierSearchList.add("general_brigadier");
            Toast.makeText(this, "No results matched your query", Toast.LENGTH_LONG).show();
        }
        //Log.w(TAG, "In Civilwargenerals.onClickSearch(), about to db.close()");
        db.close();
        //This works, WITH THE results+= line uncommented above, but it only displays unclickable results
        Intent iGeneral = new Intent("com.jimsuplee.civilwargenerals.General");
        startActivityForResult(iGeneral, 0);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // ---check if the request code is 0 1 2 3 4 5---
        //Log.w(TAG, "In Fighterjets.onActivityResult(), checking reqCod");
        // onClickLocation startActivityForResult section
        if (requestCode == 0) {
            //Log.w(TAG, "In Fighterjets.onActivityResult(int-reqCode=0,int-resCode,Intent-data)");
            if (resultCode == RESULT_OK) {
                String general = data.getData().toString();
                String results = " ";
                db.open();
                Cursor c;
                //Log.w(TAG, "In Civilwargenerals.onActivityResult(0,ok), got general_"+general+"_");
                //Log.w(TAG, "about to c = db.getByGeneralName(general);");
                c = db.getByGeneralName(general);
                //ImageView iv = (ImageView) findViewById(R.id.imagedetail);
                if (c != null) {
                    //Log.w(TAG, "In Fighterjets.onActivityResult(), cursor c isnot null.");
                }
                //Log.w(TAG, "In Fighterjets.onActivityResult(), about to c.moveToFirst()");
                if (c.moveToFirst()) {
                    //Log.w(TAG, "In Fighterjets.onActivityResult(), c.moveToFirst() returned true");
                    do {
                        //results +=  "RESULTS: "+c.getString(0) ;
                        //WORKS but has duplicated info:
                        // results += "keyName:"+c.getString(0)+"\nGeneral:"+c.getString(1)+"\nGeneralData:"+c.getString(2)+"\nArmy:"+c.getString(3)+"___";;
                        //results += "General:"+c.getString(1)+"\n\n"+c.getString(2)+"___";
                        results += "<b>General:"+c.getString(1)+"</b>\n\n"+c.getString(2)+"___";
                        //com.jimsuplee.aircraftcarriers.Aircraftcarriers.carrierSearchList.add(c.getString(0));
                        //photoMap.get(c.getString(1));
                        //iv.setImageResource(R.drawable.fighterjets240);
                        //countryInteger=photoMap.get(c.getString(0));
                    } while (c.moveToNext());
                }else {
                    //Log.w(TAG, "In Fighterjets.onActivityResult(), c.moveToFirst() returned NOT TRUE");
                }
                //Populate activity with data retrieved for general
                //TextView tv;
                ImageView iv = (ImageView) findViewById(R.id.imagedetail);
                Integer photoId = photoMap.get(general);
                if(photoId != null) {
                    iv.setImageResource(photoMap.get(general));
                } else if(army.equals("union")) {
                    iv.setImageResource(photoMap.get("union"));
                } else if(army.equals("confederate")) {
                    iv.setImageResource(photoMap.get("confederate"));
                } else {
                    iv.setImageResource(R.drawable.civilwar);
                }
                TextView tv = (TextView) findViewById(R.id.txt_general);
                Spanned resultsHtml = Html.fromHtml(results);
                tv.setText(resultsHtml);

            }
//        }else if (requestCode == 1) {
//            //Log.w(TAG, "In Fighterjets.onActivityResult(int-reqCode=1,int-resCode,Intent-data)");
//            if (resultCode == RESULT_OK) {
//                Intent iGeneral = new Intent("com.jimsuplee.civilwargenerals.General");
//                Civilwargenerals.army="all";
//                startActivityForResult(iGeneral,0);
//            }
        }
    }
}
