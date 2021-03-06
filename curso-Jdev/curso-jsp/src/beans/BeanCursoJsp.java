package beans;

public class BeanCursoJsp {

	private long id;
	private String login;
	private String passwd;
	private String user;
	private String fone;

	private String cep;
	private String endereco;
	private String endNum;
	private String bairro;
	private String cidade;
	private String uf;

	private String fotoBase64;
	private String contentType;
	private String tempFotouser;

	private String cvBase64;
	private String contentTypeCv;
	private String tempCvUser;

	private String fotoBase64Min;

	private boolean ativo;
	private String sexo;
	private String perfil;

	private boolean atualizarImg = true;
	private boolean atualizarCv = true;

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isAtualizarImg() {
		return atualizarImg;
	}

	public void setAtualizarImg(boolean atualizarImg) {
		this.atualizarImg = atualizarImg;
	}

	public boolean isAtualizarCv() {
		return atualizarCv;
	}

	public void setAtualizarCv(boolean atualizarCv) {
		this.atualizarCv = atualizarCv;
	}

	public String getFotoBase64Min() {
		return fotoBase64Min;
	}

	public void setFotoBase64Min(String fotoBase64Min) {
		this.fotoBase64Min = fotoBase64Min;
	}

	public String getContentTypeCv() {
		return contentTypeCv;
	}

	public void setContentTypeCv(String contentTypeCv) {
		this.contentTypeCv = contentTypeCv;
	}

	public void setCvBase64(String cvBase64) {
		this.cvBase64 = cvBase64;
	}

	public String getCvBase64() {
		return cvBase64;
	}

	public String getTempCvUser() {

		tempCvUser = "data:" + contentTypeCv + ";base64," + cvBase64;

		return tempCvUser;
	}

	/* Monta em tempo de execu��o */
	public String getTempFotouser() {

		tempFotouser = "data:" + contentType + ";base64," + fotoBase64;

		return tempFotouser;
	}

	public String getFotoBase64() {
		return fotoBase64;
	}

	public void setFotoBase64(String fotoBase64) {
		this.fotoBase64 = fotoBase64;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndNum() {
		return endNum;
	}

	public void setEndNum(String endNum) {
		this.endNum = endNum;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getFone() {
		return fone;
	}

}
