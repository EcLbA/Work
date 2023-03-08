package com.loubii.account.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import com.loubii.account.db.DaoSession;
import com.loubii.account.db.AccountModelDao;
import com.loubii.account.db.BookBeanDao;

import java.util.List;

@Entity
public class BookBean {

    @ToMany(referencedJoinProperty = "bookID")
    private List<AccountModel> accountModellist;
    @Id
    private Long BookId;
    private String BookName;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1221394370)
    private transient BookBeanDao myDao;
    @Generated(hash = 379704436)
    public BookBean(Long BookId, String BookName) {
        this.BookId = BookId;
        this.BookName = BookName;
    }
    @Generated(hash = 269018259)
    public BookBean() {
    }
    public Long getBookId() {
        return this.BookId;
    }
    public void setBookId(Long BookId) {
        this.BookId = BookId;
    }
    public String getBookName() {
        return this.BookName;
    }
    public void setBookName(String BookName) {
        this.BookName = BookName;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 2099380790)
    public List<AccountModel> getAccountModellist() {
        if (accountModellist == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AccountModelDao targetDao = daoSession.getAccountModelDao();
            List<AccountModel> accountModellistNew = targetDao
                    ._queryBookBean_AccountModellist(BookId);
            synchronized (this) {
                if (accountModellist == null) {
                    accountModellist = accountModellistNew;
                }
            }
        }
        return accountModellist;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1480089391)
    public synchronized void resetAccountModellist() {
        accountModellist = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 449821274)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBookBeanDao() : null;
    }

}