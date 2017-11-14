/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zc
 */
@Entity
@Table(name = "autoline_hacking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutolineHacking.findAll", query = "SELECT a FROM AutolineHacking a"),
    @NamedQuery(name = "AutolineHacking.findById", query = "SELECT a FROM AutolineHacking a WHERE a.id = :id"),
    @NamedQuery(name = "AutolineHacking.findByAa", query = "SELECT a FROM AutolineHacking a WHERE a.aa = :aa"),
    @NamedQuery(name = "AutolineHacking.findByAj", query = "SELECT a FROM AutolineHacking a WHERE a.aj = :aj"),
    @NamedQuery(name = "AutolineHacking.findByAk", query = "SELECT a FROM AutolineHacking a WHERE a.ak = :ak"),
    @NamedQuery(name = "AutolineHacking.findByAr", query = "SELECT a FROM AutolineHacking a WHERE a.ar = :ar"),
    @NamedQuery(name = "AutolineHacking.findByCd", query = "SELECT a FROM AutolineHacking a WHERE a.cd = :cd"),
    @NamedQuery(name = "AutolineHacking.findByDd", query = "SELECT a FROM AutolineHacking a WHERE a.dd = :dd"),
    @NamedQuery(name = "AutolineHacking.findByDr", query = "SELECT a FROM AutolineHacking a WHERE a.dr = :dr"),
    @NamedQuery(name = "AutolineHacking.findByMa", query = "SELECT a FROM AutolineHacking a WHERE a.ma = :ma"),
    @NamedQuery(name = "AutolineHacking.findByMk", query = "SELECT a FROM AutolineHacking a WHERE a.mk = :mk"),
    @NamedQuery(name = "AutolineHacking.findByNl", query = "SELECT a FROM AutolineHacking a WHERE a.nl = :nl"),
    @NamedQuery(name = "AutolineHacking.findByPc", query = "SELECT a FROM AutolineHacking a WHERE a.pc = :pc"),
    @NamedQuery(name = "AutolineHacking.findByPl", query = "SELECT a FROM AutolineHacking a WHERE a.pl = :pl"),
    @NamedQuery(name = "AutolineHacking.findBySc", query = "SELECT a FROM AutolineHacking a WHERE a.sc = :sc"),
    @NamedQuery(name = "AutolineHacking.findBySl", query = "SELECT a FROM AutolineHacking a WHERE a.sl = :sl"),
    @NamedQuery(name = "AutolineHacking.findBySm", query = "SELECT a FROM AutolineHacking a WHERE a.sm = :sm"),
    @NamedQuery(name = "AutolineHacking.findBySo", query = "SELECT a FROM AutolineHacking a WHERE a.so = :so"),
    @NamedQuery(name = "AutolineHacking.findBySr", query = "SELECT a FROM AutolineHacking a WHERE a.sr = :sr"),
    @NamedQuery(name = "AutolineHacking.findBySu", query = "SELECT a FROM AutolineHacking a WHERE a.su = :su"),
    @NamedQuery(name = "AutolineHacking.findByVs", query = "SELECT a FROM AutolineHacking a WHERE a.vs = :vs"),
    @NamedQuery(name = "AutolineHacking.findByWl", query = "SELECT a FROM AutolineHacking a WHERE a.wl = :wl"),
    @NamedQuery(name = "AutolineHacking.findByGb", query = "SELECT a FROM AutolineHacking a WHERE a.gb = :gb"),
    @NamedQuery(name = "AutolineHacking.findByUseShortNames", query = "SELECT a FROM AutolineHacking a WHERE a.useShortNames = :useShortNames"),
    @NamedQuery(name = "AutolineHacking.findByMs", query = "SELECT a FROM AutolineHacking a WHERE a.ms = :ms"),
    @NamedQuery(name = "AutolineHacking.findByCm", query = "SELECT a FROM AutolineHacking a WHERE a.cm = :cm"),
    @NamedQuery(name = "AutolineHacking.findByVm", query = "SELECT a FROM AutolineHacking a WHERE a.vm = :vm"),
    @NamedQuery(name = "AutolineHacking.findByAaBranch", query = "SELECT a FROM AutolineHacking a WHERE a.aaBranch = :aaBranch"),
    @NamedQuery(name = "AutolineHacking.findByAjBranch", query = "SELECT a FROM AutolineHacking a WHERE a.ajBranch = :ajBranch"),
    @NamedQuery(name = "AutolineHacking.findByAkBranch", query = "SELECT a FROM AutolineHacking a WHERE a.akBranch = :akBranch"),
    @NamedQuery(name = "AutolineHacking.findByArBranch", query = "SELECT a FROM AutolineHacking a WHERE a.arBranch = :arBranch"),
    @NamedQuery(name = "AutolineHacking.findByCdBranch", query = "SELECT a FROM AutolineHacking a WHERE a.cdBranch = :cdBranch"),
    @NamedQuery(name = "AutolineHacking.findByDdBranch", query = "SELECT a FROM AutolineHacking a WHERE a.ddBranch = :ddBranch"),
    @NamedQuery(name = "AutolineHacking.findByDrBranch", query = "SELECT a FROM AutolineHacking a WHERE a.drBranch = :drBranch"),
    @NamedQuery(name = "AutolineHacking.findByMaBranch", query = "SELECT a FROM AutolineHacking a WHERE a.maBranch = :maBranch"),
    @NamedQuery(name = "AutolineHacking.findByMkBranch", query = "SELECT a FROM AutolineHacking a WHERE a.mkBranch = :mkBranch"),
    @NamedQuery(name = "AutolineHacking.findByNlBranch", query = "SELECT a FROM AutolineHacking a WHERE a.nlBranch = :nlBranch"),
    @NamedQuery(name = "AutolineHacking.findByPcBranch", query = "SELECT a FROM AutolineHacking a WHERE a.pcBranch = :pcBranch"),
    @NamedQuery(name = "AutolineHacking.findByPlBranch", query = "SELECT a FROM AutolineHacking a WHERE a.plBranch = :plBranch"),
    @NamedQuery(name = "AutolineHacking.findByScBranch", query = "SELECT a FROM AutolineHacking a WHERE a.scBranch = :scBranch"),
    @NamedQuery(name = "AutolineHacking.findBySlBranch", query = "SELECT a FROM AutolineHacking a WHERE a.slBranch = :slBranch"),
    @NamedQuery(name = "AutolineHacking.findBySmBranch", query = "SELECT a FROM AutolineHacking a WHERE a.smBranch = :smBranch"),
    @NamedQuery(name = "AutolineHacking.findBySoBranch", query = "SELECT a FROM AutolineHacking a WHERE a.soBranch = :soBranch"),
    @NamedQuery(name = "AutolineHacking.findBySrBranch", query = "SELECT a FROM AutolineHacking a WHERE a.srBranch = :srBranch"),
    @NamedQuery(name = "AutolineHacking.findBySuBranch", query = "SELECT a FROM AutolineHacking a WHERE a.suBranch = :suBranch"),
    @NamedQuery(name = "AutolineHacking.findByVsBranch", query = "SELECT a FROM AutolineHacking a WHERE a.vsBranch = :vsBranch"),
    @NamedQuery(name = "AutolineHacking.findByWlBranch", query = "SELECT a FROM AutolineHacking a WHERE a.wlBranch = :wlBranch"),
    @NamedQuery(name = "AutolineHacking.findByGbBranch", query = "SELECT a FROM AutolineHacking a WHERE a.gbBranch = :gbBranch"),
    @NamedQuery(name = "AutolineHacking.findByMsBranch", query = "SELECT a FROM AutolineHacking a WHERE a.msBranch = :msBranch"),
    @NamedQuery(name = "AutolineHacking.findByCmBranch", query = "SELECT a FROM AutolineHacking a WHERE a.cmBranch = :cmBranch"),
    @NamedQuery(name = "AutolineHacking.findByVmBranch", query = "SELECT a FROM AutolineHacking a WHERE a.vmBranch = :vmBranch")})
public class AutolineHacking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "aa")
    private String aa;
    @Basic(optional = false)
    @Column(name = "aj")
    private String aj;
    @Basic(optional = false)
    @Column(name = "ak")
    private String ak;
    @Basic(optional = false)
    @Column(name = "ar")
    private String ar;
    @Basic(optional = false)
    @Column(name = "cd")
    private String cd;
    @Basic(optional = false)
    @Column(name = "dd")
    private String dd;
    @Basic(optional = false)
    @Column(name = "dr")
    private String dr;
    @Basic(optional = false)
    @Column(name = "ma")
    private String ma;
    @Basic(optional = false)
    @Column(name = "mk")
    private String mk;
    @Basic(optional = false)
    @Column(name = "nl")
    private String nl;
    @Basic(optional = false)
    @Column(name = "pc")
    private String pc;
    @Basic(optional = false)
    @Column(name = "pl")
    private String pl;
    @Basic(optional = false)
    @Column(name = "sc")
    private String sc;
    @Basic(optional = false)
    @Column(name = "sl")
    private String sl;
    @Basic(optional = false)
    @Column(name = "sm")
    private String sm;
    @Basic(optional = false)
    @Column(name = "so")
    private String so;
    @Basic(optional = false)
    @Column(name = "sr")
    private String sr;
    @Basic(optional = false)
    @Column(name = "su")
    private String su;
    @Basic(optional = false)
    @Column(name = "vs")
    private String vs;
    @Basic(optional = false)
    @Column(name = "wl")
    private String wl;
    @Column(name = "gb")
    private String gb;
    @Column(name = "use_short_names")
    private Boolean useShortNames;
    @Basic(optional = false)
    @Column(name = "ms")
    private String ms;
    @Basic(optional = false)
    @Column(name = "cm")
    private String cm;
    @Basic(optional = false)
    @Column(name = "vm")
    private String vm;
    @Column(name = "aa_branch")
    private String aaBranch;
    @Column(name = "aj_branch")
    private String ajBranch;
    @Column(name = "ak_branch")
    private String akBranch;
    @Column(name = "ar_branch")
    private String arBranch;
    @Column(name = "cd_branch")
    private String cdBranch;
    @Column(name = "dd_branch")
    private String ddBranch;
    @Column(name = "dr_branch")
    private String drBranch;
    @Column(name = "ma_branch")
    private String maBranch;
    @Column(name = "mk_branch")
    private String mkBranch;
    @Column(name = "nl_branch")
    private String nlBranch;
    @Column(name = "pc_branch")
    private String pcBranch;
    @Column(name = "pl_branch")
    private String plBranch;
    @Column(name = "sc_branch")
    private String scBranch;
    @Column(name = "sl_branch")
    private String slBranch;
    @Column(name = "sm_branch")
    private String smBranch;
    @Column(name = "so_branch")
    private String soBranch;
    @Column(name = "sr_branch")
    private String srBranch;
    @Column(name = "su_branch")
    private String suBranch;
    @Column(name = "vs_branch")
    private String vsBranch;
    @Column(name = "wl_branch")
    private String wlBranch;
    @Column(name = "gb_branch")
    private String gbBranch;
    @Column(name = "ms_branch")
    private String msBranch;
    @Column(name = "cm_branch")
    private String cmBranch;
    @Column(name = "vm_branch")
    private String vmBranch;
    @OneToMany(mappedBy = "autolinehackingId")
    private List<LogEntry> logEntryList;
    @OneToMany(mappedBy = "autolineHackingId")
    private List<Dealer> dealerList;

    public AutolineHacking() {
    }

    public AutolineHacking(Integer id) {
        this.id = id;
    }

    public AutolineHacking(Integer id, String aa, String aj, String ak, String ar, String cd, String dd, String dr, String ma, String mk, String nl, String pc, String pl, String sc, String sl, String sm, String so, String sr, String su, String vs, String wl, String ms, String cm, String vm) {
        this.id = id;
        this.aa = aa;
        this.aj = aj;
        this.ak = ak;
        this.ar = ar;
        this.cd = cd;
        this.dd = dd;
        this.dr = dr;
        this.ma = ma;
        this.mk = mk;
        this.nl = nl;
        this.pc = pc;
        this.pl = pl;
        this.sc = sc;
        this.sl = sl;
        this.sm = sm;
        this.so = so;
        this.sr = sr;
        this.su = su;
        this.vs = vs;
        this.wl = wl;
        this.ms = ms;
        this.cm = cm;
        this.vm = vm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getAj() {
        return aj;
    }

    public void setAj(String aj) {
        this.aj = aj;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getSu() {
        return su;
    }

    public void setSu(String su) {
        this.su = su;
    }

    public String getVs() {
        return vs;
    }

    public void setVs(String vs) {
        this.vs = vs;
    }

    public String getWl() {
        return wl;
    }

    public void setWl(String wl) {
        this.wl = wl;
    }

    public String getGb() {
        return gb;
    }

    public void setGb(String gb) {
        this.gb = gb;
    }

    public Boolean getUseShortNames() {
        return useShortNames;
    }

    public void setUseShortNames(Boolean useShortNames) {
        this.useShortNames = useShortNames;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getCm() {
        return cm;
    }

    public void setCm(String cm) {
        this.cm = cm;
    }

    public String getVm() {
        return vm;
    }

    public void setVm(String vm) {
        this.vm = vm;
    }

    public String getAaBranch() {
        return aaBranch;
    }

    public void setAaBranch(String aaBranch) {
        this.aaBranch = aaBranch;
    }

    public String getAjBranch() {
        return ajBranch;
    }

    public void setAjBranch(String ajBranch) {
        this.ajBranch = ajBranch;
    }

    public String getAkBranch() {
        return akBranch;
    }

    public void setAkBranch(String akBranch) {
        this.akBranch = akBranch;
    }

    public String getArBranch() {
        return arBranch;
    }

    public void setArBranch(String arBranch) {
        this.arBranch = arBranch;
    }

    public String getCdBranch() {
        return cdBranch;
    }

    public void setCdBranch(String cdBranch) {
        this.cdBranch = cdBranch;
    }

    public String getDdBranch() {
        return ddBranch;
    }

    public void setDdBranch(String ddBranch) {
        this.ddBranch = ddBranch;
    }

    public String getDrBranch() {
        return drBranch;
    }

    public void setDrBranch(String drBranch) {
        this.drBranch = drBranch;
    }

    public String getMaBranch() {
        return maBranch;
    }

    public void setMaBranch(String maBranch) {
        this.maBranch = maBranch;
    }

    public String getMkBranch() {
        return mkBranch;
    }

    public void setMkBranch(String mkBranch) {
        this.mkBranch = mkBranch;
    }

    public String getNlBranch() {
        return nlBranch;
    }

    public void setNlBranch(String nlBranch) {
        this.nlBranch = nlBranch;
    }

    public String getPcBranch() {
        return pcBranch;
    }

    public void setPcBranch(String pcBranch) {
        this.pcBranch = pcBranch;
    }

    public String getPlBranch() {
        return plBranch;
    }

    public void setPlBranch(String plBranch) {
        this.plBranch = plBranch;
    }

    public String getScBranch() {
        return scBranch;
    }

    public void setScBranch(String scBranch) {
        this.scBranch = scBranch;
    }

    public String getSlBranch() {
        return slBranch;
    }

    public void setSlBranch(String slBranch) {
        this.slBranch = slBranch;
    }

    public String getSmBranch() {
        return smBranch;
    }

    public void setSmBranch(String smBranch) {
        this.smBranch = smBranch;
    }

    public String getSoBranch() {
        return soBranch;
    }

    public void setSoBranch(String soBranch) {
        this.soBranch = soBranch;
    }

    public String getSrBranch() {
        return srBranch;
    }

    public void setSrBranch(String srBranch) {
        this.srBranch = srBranch;
    }

    public String getSuBranch() {
        return suBranch;
    }

    public void setSuBranch(String suBranch) {
        this.suBranch = suBranch;
    }

    public String getVsBranch() {
        return vsBranch;
    }

    public void setVsBranch(String vsBranch) {
        this.vsBranch = vsBranch;
    }

    public String getWlBranch() {
        return wlBranch;
    }

    public void setWlBranch(String wlBranch) {
        this.wlBranch = wlBranch;
    }

    public String getGbBranch() {
        return gbBranch;
    }

    public void setGbBranch(String gbBranch) {
        this.gbBranch = gbBranch;
    }

    public String getMsBranch() {
        return msBranch;
    }

    public void setMsBranch(String msBranch) {
        this.msBranch = msBranch;
    }

    public String getCmBranch() {
        return cmBranch;
    }

    public void setCmBranch(String cmBranch) {
        this.cmBranch = cmBranch;
    }

    public String getVmBranch() {
        return vmBranch;
    }

    public void setVmBranch(String vmBranch) {
        this.vmBranch = vmBranch;
    }

    @XmlTransient
    public List<LogEntry> getLogEntryList() {
        return logEntryList;
    }

    public void setLogEntryList(List<LogEntry> logEntryList) {
        this.logEntryList = logEntryList;
    }

    @XmlTransient
    public List<Dealer> getDealerList() {
        return dealerList;
    }

    public void setDealerList(List<Dealer> dealerList) {
        this.dealerList = dealerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutolineHacking)) {
            return false;
        }
        AutolineHacking other = (AutolineHacking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.database.jpa.hibernate.jndi.AutolineHacking[ id=" + id + " ]";
    }
    
}
